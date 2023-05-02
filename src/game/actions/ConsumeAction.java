package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * An action that allows Actor to consume consumable items
 * @author AppliedSession03Gropu03
 */
public class ConsumeAction extends Action {

    /**
     * The consumable item
     */
    final private Consumable consumable;

    /**
     * A public constructor
     * @param consumable The consumable item
     */
    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * When executed the Actor is allowed to consume the consumable item
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the item consumption
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        consumable.consumedBy(actor);
        return actor.toString() + " has consumed " + consumable.getName() + "\n" + consumable.getEffect();
    }

    /**
     * Describes which item the Actor can consume
     *
     * @param actor The actor performing the action.
     * @return a description used in menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Consume " + this.consumable.getName() + " (" + this.consumable.getUsesLeft() + " uses left)";
    }
}
