package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.Reviver;

/**
 * An action that revives the enemy that spawned the actor performing this action
 * @author AppliedSession03Group03
 */
public class ReviveAction extends Action {

    /**
     * The Actor to be revived
     */
    private Actor toRevive;

    /**
     * A public constructor
     * @param reviver The actor who is going to revive toRevive
     */
    public ReviveAction(Reviver reviver) {
        this.toRevive = reviver.getSpawner();
    }

    /**
     * Revives toRevive and removes the Actor performing teh action from the game
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        map.removeActor(actor);
        this.toRevive.heal(Integer.MAX_VALUE);
        here.addActor(this.toRevive);
        return this.toRevive + " has been revived from " + actor;
    }

    /**
     * Describes the Actor being revived
     * @param actor The actor performing the action.
     * @return A description for menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return this.toRevive + " has been revived ";
    }
}
