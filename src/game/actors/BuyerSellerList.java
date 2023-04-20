package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.traderactions.BuySellCapable;

import java.util.ArrayList;

public class BuyerSellerList {
    private static BuyerSellerList instance = null;
    private ArrayList<BuySellCapable> buyerSellers = new ArrayList<>();

    private BuyerSellerList() {}

    public static BuyerSellerList getInstance() {
        if (instance == null) {
            instance = new BuyerSellerList();
        }
        return instance;
    }

    public void addBuyerSeller(BuySellCapable buyerSeller) {
        this.buyerSellers.add(buyerSeller);
    }

    public boolean isBuyerSeller(Actor actor) {
        for (BuySellCapable buyerSeller: this.buyerSellers) {
            if (buyerSeller.toString().equals(actor.toString())) {
                return true;
            }
        }
        return false;
    }

    public BuySellCapable getBuyerSeller(Actor actor) {
        for (BuySellCapable buyerSeller: this.buyerSellers) {
            if (buyerSeller.toString().equals(actor.toString())) {
                return buyerSeller;
            }
        }
        return null;
    }

}
