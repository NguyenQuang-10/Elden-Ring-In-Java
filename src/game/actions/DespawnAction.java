package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

import java.util.Random;

public class DespawnAction extends Action {

    private int despawnProb;
    private boolean despawned = false;

    public DespawnAction(int despawnProb) {
        this.despawnProb = despawnProb;
    }


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

    @Override
    public String menuDescription(Actor actor) {
        if (this.despawned) {
            return actor + " has been despawned.";
        }
        return null;
    }
}
