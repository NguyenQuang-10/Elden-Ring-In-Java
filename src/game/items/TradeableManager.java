package game.items;

import game.weapons.*;

import java.util.ArrayList;

/**
 * Keep track of which item a Player and Trader is allowed to buy and sell
 * @see Purchaseable
 * @see Sellable
 * @see game.actors.Player
 * @see game.actors.Trader
 */
public class TradeableManager {
    /**
     * The list of item that the player are allowed to purchase
     */
    private ArrayList<Purchaseable> purchaseables = new ArrayList<>();
    /**
     * The list of item the player are allowed to sell
     */
    private ArrayList<Sellable> sellables = new ArrayList<>();
    /**
     * The singleton instance of this class
     */
    private static TradeableManager instance = null;

    /**
     * Constructor
     */
    private TradeableManager() {
        this.addPurchaseableItem(new Club());
        this.addPurchaseableItem(new GreatKnife());
        this.addPurchaseableItem(new Uchigatana());
        this.addPurchaseableItem(new Scimitar());

        this.addSellableItem(new Club());
        this.addSellableItem(new GreatKnife());
        this.addSellableItem(new Uchigatana());
        this.addSellableItem(new Scimitar());
        this.addSellableItem(new Grossmesser());
    }

    /**
     * Factory method to ensure singleton status
     * @return Instance of the class
     */
    public static TradeableManager getInstance() {
        if (instance == null) {
            instance = new TradeableManager();
        }
        return instance;
    }

    /**
     * Add a purchaseable item to the list
     * @param purchaseable the purchaseable
     */
    public void addPurchaseableItem(Purchaseable purchaseable) {
        this.purchaseables.add(purchaseable);
    }

    /**
     * Getter for purchaseables list
     * @return purchaseable item
     */
    public ArrayList<Purchaseable> getPurchaseables() {
        return this.purchaseables;
    }

    /**
     * Add a sellable item to the list
     * @param sellable - the sellable list
     */
    public void addSellableItem(Sellable sellable) {
        this.sellables.add(sellable);
    }

    /**
     * Getter for the sellable list
     * @return the sellable list
     */
    public ArrayList<Sellable> getSellables() {
        return this.sellables;
    }
}
