package game.actions.traderactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchaseable;

/**
*   A class that represent the action of an BuySellCapable buying from a trader
 *  @author AppliedSession03Group03
*/
public class BuyAction extends Action {
    /**
     * The item to be bought
     */
    final private WeaponItem item;
    /**
     * The price to sell for
     */
    final private int price;
    /**
     * The buyer
     */
    final private BuySellCapable buyer;

    /**
     * Initialize the BuyAction
     *
     * @param item - the item to be bought
     * @param buyer - the buyer
     */
    public BuyAction(Purchaseable item, BuySellCapable buyer){
        this.item = item.purchaseItem();
        this.price = item.getPurchasePrice();
        this.buyer = buyer;
    }

    /**
     * If buyer has sufficient funds, decrease their rune balance and add item to their inventory
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String representing the status of the sale
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (this.buyer.runeBalance() >= this.price) {
            this.buyer.minusRuneBalance(this.price);
            this.buyer.addToInventory(this.item);
            return "Successfully bought " + this.item.toString() + " for " + this.price;
        } else {
            return "Unable to buy " + this.item.toString() + " due to insufficient funds.";
        }

    }

    /** Returns the menu descriptor of the action
     *
     * @param actor The actor performing the action.
     * @return The menu description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Buy " + this.item.toString() + " for " + this.price + " runes";
    }
}