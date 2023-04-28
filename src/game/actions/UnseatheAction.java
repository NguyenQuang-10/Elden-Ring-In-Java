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

/**
 * Performs unsheate action on target (an attack where the weapon hitrate is 60 and the damage
 * of the weapon is doubled)
 * @author AppliedSession03Gropu03
 */
public class UnseatheAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * A public constructor
     *
     * @param target The Actor that is to be attacked
     * @param direction The direction of incoming attack.
     * @param weapon Weapon used for the attack
     */
    public UnseatheAction(Actor target, String direction, Weapon weapon){
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * This method executes the unique skill to the Uchigatana, it deals 2x damage from weapon with a 60% hit rate.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
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

    /**
     * Describe which actor performs unsheate on which target
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " unsheates " + target + " at " + direction + " with " + weapon;
    }


}
