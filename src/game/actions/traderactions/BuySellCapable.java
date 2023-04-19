package game.actions.traderactions;

import edu.monash.fit2099.engine.items.Item;

/** Implemented by Player (maybe other Actor?) so that Buy and Sell action could be executed on it
 *
 * @see game.actors.Player
 * @see BuyAction
 * @see SellAction
 */
public interface BuySellCapable {
    /**
     * Used for retrieving the rune balance of the Actor
     * @return int that represent the balance
     */
    int runeBalance();

    /**
     * Modify the rune balance of the Actor
     * @param amount - the amount to modify balance, negative int means deduct from balance
     */
    void modifyRuneBalance(int amount);

    /**
     * Remove an item from the inventory of the Actor
     * @param item - the item to be removed
     */
    void removeFromInventory(Item item);

    /**
     * Add an item to the inventory of the Actor
     * @param item - the item to be added
     */
    void addToInventory(Item item);

    /**
     * Check whether the Actor posses and item
     * @param item - the item to be checked
     * @return boolean - true if the Actor do have it in their inventory, false otherwise
     */
    boolean isItemInInventory(Item item);
}