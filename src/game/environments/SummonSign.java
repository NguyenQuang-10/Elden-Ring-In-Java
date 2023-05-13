package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SummonAction;
import game.utils.Status;

public class SummonSign extends Ground {
    /**
     * Constructor.
     */
    public SummonSign() {
        super('=');
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = super.allowableActions(actor, location, direction);
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY) & actor.hasCapability(Status.PLAYER)) {
            actions.add(new SummonAction());
        }
        return actions;
    }
}
