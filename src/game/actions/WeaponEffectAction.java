package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.WeaponEffect;

/**
 * Req 5
 *
 * Action for special skill of Weapon with WeaponEffect (ConcussionStaff and PoisonedAxe)
 * @author AppliedSession03Group03
 */
public class WeaponEffectAction extends Action {

    /**
     * If Actor is poisoned, the Actor is hurt with 50 damage
     * If Actor is fainted, teh Actor does nothing
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return  the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(WeaponEffect.POISONED)) {
            actor.hurt(50);
            return actor + " has been poisoned for 50 damage";
        }
        return actor + " is still fainted";
    }

    /**
     * Description for Menu UI
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
