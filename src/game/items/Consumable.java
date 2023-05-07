package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.ConsumeAction;

/**
 * Interface that represents item that can be consume a finite of time by an Actor
 * @author AppliedSession03Group03
 */
public interface Consumable {
    /**
     * @return the int representing the number of use the item has left
     */
    int getUsesLeft();

    /**
     * @return the ConsumeAction representing the item being used
     */
    ConsumeAction getConsumeAction();

    /**
     * Use the item on an actor
     * @param actor that is used on
     */
    void consumedBy(Actor actor);

    /**
     * @return String that represent the effect the item has
     */
    String getEffect();

}
