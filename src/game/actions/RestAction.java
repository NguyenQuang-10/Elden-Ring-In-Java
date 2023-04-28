package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Allows the actor to rest at the SiteOfLostGRace
 *
 * @author AppliedSession03Gropu03
 */
public class RestAction extends Action {

    /**
     * The name of the site of lost grace
     */
    private String ground;

    /**
     * A public constructor
     * @param ground The name of the site of lost grace
     */
    public RestAction(String ground) {
        this.ground = ground;
    }

    /**
     * Allows the actor to rest at site of lost grace and resets the entire game
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return (new ResetAction()).execute(actor, map);
    }

    /**
     * Describes the actor resting at the site of lost grace
     *
     * @param actor The actor performing the action.
     * @return a description for menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at " + this.ground;
    }
}
