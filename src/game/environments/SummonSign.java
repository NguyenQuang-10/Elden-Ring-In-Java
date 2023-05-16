package game.environments;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SummonAction;
import game.utils.Status;

/**
 * A class that represents summon sign.
 * @author AppliedSession03Group03
 * @see Ground
 */
public class SummonSign extends Ground {
    /**
     * A public constructor.
     */
    public SummonSign() {
        super('=');
    }

    /**
     * Method that returns a list of allowable actions when at the summon sign.
     * @param actor     The actor to determine if they can summon.
     * @param location  The current location.
     * @param direction The direction of the ground from the Actor.
     * @return          The list of actions that the actor can do at the summon sign.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = super.allowableActions(actor, location, direction);
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY) & actor.hasCapability(Status.PLAYER)) {
            actions.add(new SummonAction());
        }
        return actions;
    }
}
