package game.actions.traderactions;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Rune;

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
     *
     * @param weapon
     */
    void removeFromInventory(WeaponItem weapon);

    /**
     * Add an item to the inventory of the Actor
     *
     * @param weapon
     */
    void addToInventory(WeaponItem weapon);

    /**
     * Check whether the Actor posses and item
     *
     * @param weapon@return boolean - true if the Actor do have it in their inventory, false otherwise
     */
    boolean isInInventory(WeaponItem weapon);

    void addRune(Rune rune);
}