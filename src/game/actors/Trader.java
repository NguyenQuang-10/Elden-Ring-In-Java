package game.actors;

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
import game.items.PurchaseableWeapon;
import game.items.SellableWeapon;
import game.utils.Status;

import java.util.ArrayList;

public abstract class Trader extends Actor {

    /**
     * The list of item that the player are allowed to purchase
     */
    private ArrayList<PurchaseableWeapon> purchaseableWeapons = new ArrayList<>();
    /**
     * The list of item the player are allowed to sell
     */
    private ArrayList<SellableWeapon> sellableWeapons = new ArrayList<>();

    protected ArrayList<PurchaseableWeapon> getPurchaseableWeapons() {
        return purchaseableWeapons;
    }

    protected ArrayList<SellableWeapon> getSellableWeapons() {
        return sellableWeapons;
    }

    /**
     * Constructor
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     */
    public Trader(String name, char displayChar) {
        super(name, displayChar, Integer.MAX_VALUE);
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

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            BuySellCapable buyerSeller = BuyerSellerList.getInstance().getBuyerSeller(otherActor);

            for (PurchaseableWeapon item: this.getPurchaseableWeapons()) {
                actions.add(new BuyWeaponAction(item, buyerSeller));
            }

            for (WeaponItem weapon: otherActor.getWeaponInventory()) {
                for (SellableWeapon item: this.getSellableWeapons()) {
                    if (item.toString().equals(weapon.toString())) {
                        actions.add(new SellWeaponAction(weapon, item.getSellPrice(), buyerSeller));
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
