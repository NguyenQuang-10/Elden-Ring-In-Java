package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class SpawnAction extends Action {

    private Actor spawner;
    private Actor actor;

    public SpawnAction(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String execute(Actor spawner, GameMap map) {
        Location location = map.locationOf(this.spawner);

        map.removeActor(this.spawner);
        map.addActor(this.actor, location);

        return spawner + " spawning a " + actor;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is spawned";
    }
}
