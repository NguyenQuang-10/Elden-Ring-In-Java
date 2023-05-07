package game.actors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderactions.BuyAction;
import game.actions.traderactions.BuySellCapable;
import game.actions.traderactions.SellAction;
import game.items.PurchaseableWeapon;
import game.items.SellableWeapon;
import game.utils.Status;
import game.weapons.*;

import java.util.ArrayList;

/**
 * Trader that could be found on the first map is Merchant Kale,
 * represented by K (uppercase K). Merchant Kale sits around the building in the middle of the map
 * Merchant Kale allows the player to purchase weapons
 * @author AppliedSession03Group03
 */
public class MerchantKale extends Trader {

    /**
     * The list of item that the player are allowed to purchase
     */
    private ArrayList<PurchaseableWeapon> purchaseables = new ArrayList<>();
    /**
     * The list of item the player are allowed to sell
     */
    private ArrayList<SellableWeapon> sellables = new ArrayList<>();

    /**
     * A public constructor
     */
    public MerchantKale() {
        super("Merchant Kale", 'K');
        super.addCapability(Status.TRADER);
        this.purchaseables.add(new Club());
        this.purchaseables.add(new GreatKnife());
        this.purchaseables.add(new Uchigatana());
        this.purchaseables.add(new Scimitar());

        this.sellables.add(new Club());
        this.sellables.add(new GreatKnife());
        this.sellables.add(new Uchigatana());
        this.sellables.add(new Scimitar());
        this.sellables.add(new Grossmesser());
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
        ActionList actions = super.allowableActions(otherActor, direction, map);

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            BuySellCapable buyerSeller = BuyerSellerList.getInstance().getBuyerSeller(otherActor);

            for (PurchaseableWeapon item: this.purchaseables) {
                actions.add(new BuyAction(item, buyerSeller));
            }

            for (WeaponItem weapon: otherActor.getWeaponInventory()) {
                for (SellableWeapon item: this.sellables) {
                    if (item.toString().equals(weapon.toString())) {
                        actions.add(new SellAction(weapon, item.getSellPrice(), buyerSeller));
                    }
                }
            }
        }

        return actions;
    }
}
