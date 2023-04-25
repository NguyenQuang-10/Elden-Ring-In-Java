package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Uchigatana;

public class QuickStepAction extends Action {
    private WeaponItem weapon;
    private Actor target;
    private String direction;
    public QuickStepAction(WeaponItem weapon, Actor target, String direction){
        this.weapon = weapon;
        this.target = target;
        this.direction = direction;
    }

    /**
     * This method executes the unique skill to the GreatKnife, it deals the normal damage from the weapon to the enemy.
     * After which, the actor moves away from the enemy, evading their attack.
     * @param actor The actor performing the action.
     * @param gameMap The map the actor is on.
     * @return The string result of the attack.
     */
    @Override
    public String execute(Actor actor, GameMap gameMap) {
        String result = actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
        AttackAction attack = new AttackAction(target, direction, this.weapon);
        for (Exit exit : gameMap.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                // Move the actor to that location and return.
                ActorLocationsIterator actorIterator = new ActorLocationsIterator();
                actorIterator.move(actor, destination);
                return result + attack.execute(actor, gameMap);
            }
        }
        return result + attack.execute(actor, gameMap);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }


}
