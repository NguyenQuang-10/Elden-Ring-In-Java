package game.items;

import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

import java.util.ArrayList;

public class TradeableList {
    private ArrayList<Purchaseable> purchaseables = new ArrayList<>();
    private ArrayList<Sellable> sellables = new ArrayList<>();
    private static TradeableList instance = null;

    private TradeableList() {
        this.addPurchaseableItem(new Club());
        this.addPurchaseableItem(new GreatKnife());
        this.addPurchaseableItem(new Uchigatana());

        this.addSellableItem(new Club());
        this.addSellableItem(new GreatKnife());
        this.addSellableItem(new Uchigatana());
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
