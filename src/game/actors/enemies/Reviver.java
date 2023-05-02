package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface used by Actors that can revive Actors that spawned them
 * @author AppliedSession03Group03
 */
public interface Reviver {

    /**
     * Getter for spawner
     * @return The actor that spawned the Reviver
     */
    public Actor getSpawner();

    /**
     * Checks if spawner needs to be revived
     * @return true if the spawner needs to be revived else false
     */
    public boolean toRevive();
}
