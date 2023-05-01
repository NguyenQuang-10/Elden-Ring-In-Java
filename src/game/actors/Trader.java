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
import game.utils.Status;
import game.weapons.*;

import java.util.ArrayList;

/**
 * Trader that could be found on the first map is Merchant Kale,
 * represented by K (uppercase K). Merchant Kale sits around the building in the middle of the map
 * Merchant Kale allows the player to purchase weapons
 * @author AppliedSession03Gropu03
 */
public class Trader extends Actor {

    /**
     * The list of item that the player are allowed to purchase
     */
    private ArrayList<Purchaseable> purchaseables = new ArrayList<>();
    /**
     * The list of item the player are allowed to sell
     */
    private ArrayList<Sellable> sellables = new ArrayList<>();

    /**
     * A public constructor
     */
    public Trader() {
        super("Merchant Kale", 'K', Integer.MAX_VALUE);
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

            for (Purchaseable item: this.purchaseables) {
                actions.add(new BuyAction(item, buyerSeller));
            }

            for (WeaponItem weapon: otherActor.getWeaponInventory()) {
                for (Sellable item: this.sellables) {
                    if (item.toString().equals(weapon.toString())) {
                        actions.add(new SellAction(weapon, item.getSellPrice(), buyerSeller));
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
