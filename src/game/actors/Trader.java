package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderactions.BuyAction;
import game.actions.traderactions.SellAction;

import java.util.ArrayList;
import java.util.HashMap;

public class Trader extends Actor {

    /**
     * The price to pay for items when buying from trader
     */
    private ActionList buyActionList = new ActionList();
    /**
     * The price that you get for items when selling to trader
     */
    private HashMap<String, Integer> sellingPrices = new HashMap<>();

    /**
     * Initializes the trader
     */
    public Trader() {
        super("Merchant Kale", 'K', Integer.MAX_VALUE);
        // TODO: add items to buy and sell here, or add another constructor to take it from and object or hashMap
    }

    /** Add a BuyAction for all item in BuyingPrices to ActionList
     * For each item in the actor inventory, if it's available in SellingPrices, add it the ActionList
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return the ActionList of possible BuyAction and SellAction
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
//        ActionList allowedActions = new ActionList();
//        allowedActions.add(buyActionList);
//        for (WeaponItem item: otherActor.getWeaponInventory()){
//            if (this.sellingPrices.containsKey(item.toString())) {
//                allowedActions.add(SellAction(item, this.sellingPrices.get(item.toString()), otherActor ));
//            }
//        }

    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }
}
