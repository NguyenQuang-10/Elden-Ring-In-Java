package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;

public class SpawnAction extends Action {
    private Enemy toSpawn;

    public SpawnAction(Enemy toSpawn) {
        this.toSpawn = toSpawn;
    }

    @Override
    public String execute(Actor spawner, GameMap map) {
        Location location = map.locationOf(spawner);

        this.toSpawn.setSpawner(spawner);
        map.removeActor(spawner);
        map.addActor(this.toSpawn, location);

        return spawner + " spawned a " + toSpawn;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is spawned";
    }
}
