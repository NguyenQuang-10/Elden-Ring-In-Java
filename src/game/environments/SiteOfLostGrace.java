package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ResetAction;
import game.actions.RestAction;
import game.utils.Status;

public class SiteOfLostGrace extends Ground {
    /**
     * Constructor.
     *
     */

    public SiteOfLostGrace() {
        super('U');
        this.addCapability(Status.SITEOFLOSTGRACE);
    }

    /**
     * The player is allowed to rest and reset the game the site of lost grace
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList allowedActions = new ActionList();
        RestAction restAction = new RestAction("Site of Lost Grace"); // To be added
        if (location.getActor() == actor)
            allowedActions.add(restAction);
        return allowedActions;
    }


}
