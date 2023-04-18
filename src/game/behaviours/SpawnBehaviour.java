package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class SpawnBehaviour implements Behaviour {
    private Actor toSpawn;

    public SpawnBehaviour(Actor toSpawn) {
        this.toSpawn = toSpawn;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        return null;
    }
}
