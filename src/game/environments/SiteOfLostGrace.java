package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ResetAction;

public class SiteOfLostGrace extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */


    public SiteOfLostGrace() {
        super('U');
    }

    /** The player is allowed to rest and reset the game the site of lost grace
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList allowedActions = super.allowableActions(actor, location, direction);
        ResetAction resetAction = new ResetAction(); // To be added
        allowedActions.add(resetAction);

        return allowedActions;
    }


}
