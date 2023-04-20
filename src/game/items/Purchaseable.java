package game.items;

import edu.monash.fit2099.engine.items.Item;

public interface Purchaseable {
    public int getPurchasePrice();
    public Item purchaseItem();
}
