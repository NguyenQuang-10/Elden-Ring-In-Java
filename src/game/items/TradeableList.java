package game.items;

import game.weapons.*;

import java.util.ArrayList;

public class TradeableList {
    private ArrayList<Purchaseable> purchaseables = new ArrayList<>();
    private ArrayList<Sellable> sellables = new ArrayList<>();
    private static TradeableList instance = null;

    private TradeableList() {
        this.addPurchaseableItem(new Club());
        this.addPurchaseableItem(new GreatKnife());
        this.addPurchaseableItem(new Uchigatana());
        this.addPurchaseableItem(new Scimitar());

        this.addSellableItem(new Club());
        this.addSellableItem(new GreatKnife());
        this.addSellableItem(new Uchigatana());
        this.addSellableItem(new Scimitar());
        this.addSellableItem(new Grossmesser());
    };

    public static TradeableList getInstance() {
        if (instance == null) {
            instance = new TradeableList();
        }
        return instance;
    }

    public void addPurchaseableItem(Purchaseable purchaseable) {
        this.purchaseables.add(purchaseable);
    }

    public ArrayList<Purchaseable> getPurchaseables() {
        return this.purchaseables;
    }

    public void addSellableItem(Sellable sellable) {
        this.sellables.add(sellable);
    }

    public ArrayList<Sellable> getSellables() {
        return this.sellables;
    }
}
