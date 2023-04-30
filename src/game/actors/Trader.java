package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderactions.BuyAction;
import game.actions.traderactions.BuySellCapable;
import game.actions.traderactions.SellAction;
import game.items.Purchaseable;
import game.items.Sellable;
import game.items.TradeableManager;
import game.utils.Status;

import java.util.ArrayList;

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
        ActionList actions = super.allowableActions(otherActor, direction, map);

        Location here = map.locationOf(this);

        for(Exit exit: here.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {

                BuySellCapable buyerSeller = BuyerSellerList.getInstance().getBuyerSeller(otherActor);

                ArrayList<Purchaseable> purchaseables = TradeableManager.getInstance().getPurchaseables();
                for (Purchaseable item: purchaseables) {
                    actions.add(new BuyAction(item.purchaseItem(), item.getPurchasePrice(), buyerSeller));
                }

                ArrayList<Sellable> sellables = TradeableManager.getInstance().getSellables();
                for (WeaponItem weapon: otherActor.getWeaponInventory()) {
                    for (Sellable item: sellables) {
                        if (item.toString().equals(weapon.toString())) {
                            actions.add(new SellAction(weapon, item.getSellPrice(), buyerSeller));
                        }
                    }
                }
            }
        }

        return actions;
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
