package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;

public interface Reviver {
    public Actor getSpawner();
    public boolean toRevive();
}
