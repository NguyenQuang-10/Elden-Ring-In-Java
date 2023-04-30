package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.traderactions.BuySellCapable;
import game.items.Rune;

/**
 * An action to directly add Runes to the Actor (used by enemies)
 * @author AppliedSession03Gropu03
 */

public class PickUpRuneAction extends PickUpAction {

    /**
     * The Rune to be picked up
     */
    private Rune rune;

    /**
     * The Actor picking up the Rune
     */
    private BuySellCapable buyerSeller;

    /**
     * A public constructor
     * @param rune the Rune to be picked up
     * @param buyerSeller the Actor picking up the Rune
     */
    public PickUpRuneAction(Rune rune, BuySellCapable buyerSeller) {
        super(rune);
        this.rune = rune;
        this.buyerSeller = buyerSeller;
    }

    /**
     * When executed the Rune is directly added to the Rune inventory of the Actor
     * that could buy or sell using Runes
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The result of the action wether Rune is picked up or not
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).removeItem(this.rune);
        buyerSeller.addRune(this.rune);
        return menuDescription(actor);
    }

    /**
     * Describe which Actor has Rune being added directly to its Rune inventory
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + this.rune + " (value: " + this.rune.getValue() + ")";
    }
}
