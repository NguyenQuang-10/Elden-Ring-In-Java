package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SpawnAction;
import game.actors.enemies.Enemy;

/**
 * A behaviour that determines whether an enemy should spawn an enemy or not
 * @author AppliedSession03Gropu03
 */
public class SpawnBehaviour implements Behaviour {

    /**
     * The enemy to be spawned
     */
    private Enemy toSpawn;

    /**
     * A public constructor
     * @param toSpawn The enemy to be spawned
     */
    public SpawnBehaviour(Enemy toSpawn) {
        this.toSpawn = toSpawn;
    }

    /**
     * Spawns the enemy to be spawned if the Actor is dead
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return SpawnAction or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!actor.isConscious()) {
            return new SpawnAction(this.toSpawn);
        }
        return null;
    }
}
