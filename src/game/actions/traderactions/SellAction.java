package game.actions.traderactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Represent the the action of a BuySellCapable selling to the trader
 * @author AppliedSession03Group03
 * @see BuySellCapable
 */
public class SellAction extends Action {
    /**
     * Item to be sold
     */
    final private WeaponItem item;
    /**
     * Price of the item
     */
    final private int price;
    /**
     * The seller
     */
    final private BuySellCapable seller;

    /** Initialize the SellAction
     *
     * @param item - item to be sold
     * @param price - price of item
     * @param seller - the seller
     */
    public SellAction(WeaponItem item, int price, BuySellCapable seller){
        this.item = item;
        this.price = price;
        this.seller = seller;
    }

    /** If the seller has the item in their inventory, remove that item and increase their rune balance
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String that represent the status of the sale
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (this.seller.isInInventory(this.item)) {
            this.seller.addRuneBalance(this.price);
            this.seller.removeFromInventory(this.item);
            return "Successfully sold " + this.item.toString() + " for " + this.price;
        } else {
            return "Unable to sell " + this.item.toString() +  " due to item not being available in inventory";
        }

    }

    /**
     * Returns the menu descriptor of the action as a string
     * @param actor The actor performing the action.
     * @return String: the menu descriptor of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + this.item.toString() + " for " + this.price + " runes";
    }
}
