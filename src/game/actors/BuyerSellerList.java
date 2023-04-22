package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.traderactions.BuySellCapable;

import java.util.ArrayList;

public class BuyerSellerList {

    /**
     * Store instance of BuyerSellerList
     */
    private static BuyerSellerList instance = null;

    /**
     * Stores a list of Actors that can buy and sell items
     */
    private ArrayList<BuySellCapable> buyerSellers = new ArrayList<>();

    /**
     * A private constructor
     */
    private BuyerSellerList() {}

    /**
     * Factory method that ensure only one instance of BuyerSellerList exists in the game
     * @return a BuyerSeller instance
     */
    public static BuyerSellerList getInstance() {
        if (instance == null) {
            instance = new BuyerSellerList();
        }
        return instance;
    }

    /**
     * Add an Actor that can buy and sell
     * @param buyerSeller an Actor that can buy and sell
     */
    public void addBuyerSeller(BuySellCapable buyerSeller) {
        this.buyerSellers.add(buyerSeller);
    }

    /**
     * Checks if teh actor can buy and sell
     * @param actor an Actor to be checked
     * @return true if the actor can buy and sell else false
     */
    public boolean isBuyerSeller(Actor actor) {
        for (BuySellCapable buyerSeller: this.buyerSellers) {
            if (buyerSeller.toString().equals(actor.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get BuySellCapable instance of the actor that can buy and sell
     * @param actor the actor that can buy and sell
     * @return BuySellCapable instance of the actor that can buy and sell
     */
    public BuySellCapable getBuyerSeller(Actor actor) {
        for (BuySellCapable buyerSeller: this.buyerSellers) {
            if (buyerSeller.toString().equals(actor.toString())) {
                return buyerSeller;
            }
        }
        return null;
    }

}
