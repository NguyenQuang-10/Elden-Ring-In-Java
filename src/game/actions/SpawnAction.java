package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;

public class SpawnAction extends Action {

    /**
     * The Enemy to be spawned
     */
    private Enemy toSpawn;

    /**
     * A public constructor
     * @param toSpawn the Enemy to be spawned
     */
    public SpawnAction(Enemy toSpawn) {
        this.toSpawn = toSpawn;
    }

    /**
     * Spawns the Enemy represented by toSpawn and removes spawner from the game
     * @param spawner The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor spawner, GameMap map) {
        Location location = map.locationOf(spawner);
        map.removeActor(spawner);
        map.addActor(this.toSpawn, location);

        return spawner + " spawned a " + toSpawn;
    }

    /**
     * Description of the Enemy being spawned
     * @param actor The actor performing the action.
     * @return A description for menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return toSpawn + " is spawned";
    }
}
