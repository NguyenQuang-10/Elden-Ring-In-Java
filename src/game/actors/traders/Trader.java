package game.actors.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderactions.BuyWeaponAction;
import game.actions.traderactions.BuySellCapable;
import game.actions.traderactions.SellWeaponAction;
import game.actors.BuyerSellerList;
import game.items.ExchangeableItem;
import game.items.PurchaseableWeapon;
import game.items.SellableWeapon;
import game.utils.Status;

import java.util.ArrayList;

/**
 * An abstract Trader class to be inherited by Traders
 * Allows Player to perform sell and buy weapon actions when in surrounding of Trader
 * @author AppliedSession03Group03
 */
public abstract class Trader extends Actor {

    /**
     * The list of item that the player are allowed to purchase
     */
    private ArrayList<PurchaseableWeapon> purchaseableWeapons = new ArrayList<>();
    /**
     * The list of item the player are allowed to sell
     */
    private ArrayList<SellableWeapon> sellableWeapons = new ArrayList<>();

    /**
     * The list of items that the player are allowed to exchange
     */
    private ArrayList<ExchangeableItem> exchangeableItems = new ArrayList<>();

    /**
     * A public constructor
     *
     * @param name        the name of the Trader
     * @param displayChar the character that will represent the Trader in the display
     */
    public Trader(String name, char displayChar) {
        super(name, displayChar, Integer.MAX_VALUE);
        super.addCapability(Status.TRADER);
    }

    /**
     * Getter for purchaseableWeapons
     * @return purchaseableWeapons
     */
    protected ArrayList<PurchaseableWeapon> getPurchaseableWeapons() {
        return purchaseableWeapons;
    }

    /**
     * Getter for sellableWeapons
     * @return sellableWeapons
     */
    protected ArrayList<SellableWeapon> getSellableWeapons() {
        return sellableWeapons;
    }

    /**
     * Getter for exchangeableItems
     * @return exchangeableItems
     */
    protected ArrayList<ExchangeableItem> getExchangeableItems() {
        return exchangeableItems;
    }

    /**
     * Returns sell, buy and exchange actions that Player is allowed to perform
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

            for (PurchaseableWeapon item: this.getPurchaseableWeapons()) {
                actions.add(new BuyWeaponAction(item, buyerSeller));
            }


            for (SellableWeapon item: this.getSellableWeapons()) {
                actions.add(item.getSellWeaponAction(otherActor, buyerSeller));
            }


            for (ExchangeableItem exchangeItem: this.getExchangeableItems()) {
                actions.add(exchangeItem.getExchangeWeaponAction(otherActor));
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
