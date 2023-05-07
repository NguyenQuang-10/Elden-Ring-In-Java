package game.actions.traderactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.PurchaseableWeapon;

/**
*   A class that represent the action of an BuySellCapable buying from a trader
 *  @author AppliedSession03Group03
*/
public class BuyWeaponAction extends Action {

    final int price;
    final private PurchaseableWeapon weapon;

    /**
     * The buyer
     */
    final private BuySellCapable buyer;

    /**
     * Initialize the BuyAction
     *
     * @param weapon - weapon to purchase
     * @param buyer - the buyer
     */
    public BuyWeaponAction(PurchaseableWeapon weapon, BuySellCapable buyer){
        this.weapon = weapon;
        this.price = weapon.getPurchasePrice();
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
            this.buyer.addToInventory(this.weapon.purchaseItem());
            return "Successfully bought " + this.weapon.toString() + " for " + this.price;
        } else {
            return "Unable to buy " + this.weapon.toString()  + " due to insufficient funds.";
        }

    }

    /** Returns the menu descriptor of the action
     *
     * @param actor The actor performing the action.
     * @return The menu description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Buy " + this.weapon.toString() + " for " + this.price + " runes";
    }
}
