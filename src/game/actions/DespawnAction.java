package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

import java.util.Random;

public class DespawnAction extends Action {

    /**
     * The probability of an Actor being despawned
     */
    private int despawnProb;

    /**
     * Used to check if the Actor has been despawned or not for menu UI
     */
    private boolean despawned = false;

    /**
     * A public constructor
     * @param despawnProb the probability of an Actor being despawned
     */
    public DespawnAction(int despawnProb) {
        this.despawnProb = despawnProb;
    }

    /**
     * Despawns the actor (remove from the map) if the probability generated is less or same as the despawnProb
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (RandomNumberGenerator.getRandomInt(1, 100) <= this.despawnProb) {
            map.removeActor(actor);
            despawned = true;
            return actor + " is being despawned.";
        } else {
            return null;
        }
    }

    /**
     * Describes which Actor was despawned
     * @param actor The actor performing the action.
     * @return A description for menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        if (this.despawned) {
            return actor + " has been despawned.";
        }
        return null;
    }
}
