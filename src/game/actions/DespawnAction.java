package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

import java.util.Random;

public class DespawnAction extends Action {


    /**
     * Despawns the actor (remove from the map) if the probability generated is less or same as the despawnProb
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return actor + " is being despawned.";
    }

    /**
     * Describes which Actor was despawned
     * @param actor The actor performing the action.
     * @return A description for menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " has been despawned.";
    }
}
