package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.weapons.Uchigatana;

public class UnseatheAction extends Action {
    private Actor target;
    private String direction;
    private Weapon weapon;

    public UnseatheAction(Actor target, String direction, Weapon weapon){
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * This method executes the unique skill to the Uchigatana, it deals 2x damage from weapon with a 60% hit rate.
     * @param actor The actor performing the action.
     * @param gameMap The map the actor is on.
     * @return The string result of the attack.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";

        if (!(RandomNumberGenerator.getRandomInt(1,100) <= 60)) {
            return actor + " misses " + target + ".";
        } else {
            int damage = weapon.damage() * 2;
            result = actor + " unsheates with " + weapon.verb() + " " + target + " for " + damage + " damage.";
            target.hurt(damage);
            if (!target.isConscious() && target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                result += new ResetAction().execute(target, map);
            } else if (!target.isConscious()) {
                result += new DeathAction(actor).execute(target, map);
            }
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " unsheates " + target + " at " + direction + " with " + weapon;
    }


}
