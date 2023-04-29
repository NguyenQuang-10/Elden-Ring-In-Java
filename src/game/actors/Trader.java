package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Status;

/**
 * Trader that could be found on the first map is Merchant Kale,
 * represented by K (uppercase K). Merchant Kale sits around the building in the middle of the map
 * Merchant Kale allows the player to purchase weapons
 * @author AppliedSession03Gropu03
 */
public class Trader extends Actor {

    /**
     * A public constructor
     */
    public Trader() {
        super("Merchant Kale", 'K', Integer.MAX_VALUE);
        super.addCapability(Status.TRADER);
    }

    /**
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return the empty ActionList
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return super.allowableActions(otherActor, direction, map);
    }

    /**
     * Do nothing because Trader cannot move
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return do nothing
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
