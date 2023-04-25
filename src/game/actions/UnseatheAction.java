package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Uchigatana;

public class UnseatheAction extends Action {
    private final WeaponItem weapon = new Uchigatana(230, 60);
    private Actor target;
    private String direction;
    public UnseatheAction(Actor target, String direction){
        this.target = target;
        this.direction = direction;
    }

    /**
     * This method executes the unique skill to the Uchigatana, it deals 2x damage from weapon with a 60% hit rate.
     * @param actor The actor performing the action.
     * @param gameMap The map the actor is on.
     * @return The string result of the attack.
     */
    @Override
    public String execute(Actor actor, GameMap gameMap) {
        String result = actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
        AttackAction attack = new AttackAction(target, direction, this.weapon);
        return result + attack.execute(actor, gameMap);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }


}
