package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Deals normal damage to the weapon to the target and moves the target away from the attacker.
 * @author AppliedSession03Group03
 * @see Action
 */

public class QuickStepAction extends Action {

    /**
     * The weapon used in the QuickStepAction.
     */
    private WeaponItem weapon;

    /**
     * The target actor to be quick-stepped.
     */
    private Actor target;

    /**
     * The direction of the attack.
     */
    private String direction;

    /**
     * A public constructor.
     * @param weapon
     * @param target
     * @param direction
     */
    public QuickStepAction(WeaponItem weapon, Actor target, String direction){
        this.weapon = weapon;
        this.target = target;
        this.direction = direction;
    }

    /**
     * This method executes the unique skill to the GreatKnife, it deals the normal damage from the weapon to the enemy.
     * After which, the actor moves away from the enemy, evading their attack.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The string result of the attack.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " quicksteps " + target + " at " + direction + " with " + weapon + "\n";
        result += (new AttackAction(this.target, this.direction, this.weapon)).execute(actor, map);

        for (Exit exit: map.locationOf(this.target).getExits()) {
            Location here = exit.getDestination();
            if (!here.containsAnActor()) {
                return result + (new MoveActorAction(here, exit.getName(), "moved")).execute(this.target, map);
            }
        }
        return result;
    }

    /**
     * Describe which actor performs quickstep on which target.
     * @param actor The actor performing the action.
     * @return A description used for the menu UI.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " quicksteps " + target + " at " + direction + " with " + weapon;
    }
}
