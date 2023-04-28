package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ReviveAction;
import game.actors.enemies.Enemy;
import game.actors.enemies.Reviver;

/**
 * A behaviour that determines whether Reviver should revive the Actor that spawned it
 * @author AppliedSession03Gropu03
 */
public class ReviveBehaviour implements Behaviour{

    /**
     * The Actor that will revive the Actor that Spawned it
     */
    private Reviver reviver;

    /**
     * A public constructor
     * @param reviver The Actor that will revive the Actor that Spawned it
     */
    public ReviveBehaviour(Reviver reviver){
        this.reviver = reviver;
    };

    /**
     * Decides whether to revive the Actor that spawned the Reviver or not based on
     * condition set by the Reviver
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return ReviveAction or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (this.reviver.toRevive()) {
            return new ReviveAction(this.reviver);
        }
        return null;
    }
}
