package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SpawnAction;
import game.actors.enemies.Enemy;

public class SpawnBehaviour implements Behaviour {
    private Enemy toSpawn;

    public SpawnBehaviour(Enemy toSpawn) {
        this.toSpawn = toSpawn;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!actor.isConscious()) {

            return new SpawnAction(this.toSpawn);
        }
        return null;
    }
}
