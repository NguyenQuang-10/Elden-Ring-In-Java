package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAllAction;
import game.actions.DespawnAction;
import game.utils.RandomNumberGenerator;

import java.util.Random;

/**
 * A behaviour that determines whether an Actor should be despawned from the map
 * or mot based on a given probability
 * @author AppliedSession03Group03
 */
public class DespawnBehaviour implements Behaviour{

    /**
     * Probability of Actor being despawned
     */
    private int despawnProb;

    /**
     * A public constructor
     * @param despawnProb Probability of Actor being despawned
     */
    public DespawnBehaviour(int despawnProb) {
        this.despawnProb = despawnProb;
    }

    /**
     * Decides whether to despawn the Actor from map or not based on the probability
     * set in despawnProb
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return DespawnAction or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (RandomNumberGenerator.getRandomInt(1,100) <= despawnProb) {
            return new DespawnAction();
        }
        return null;
    }
}
