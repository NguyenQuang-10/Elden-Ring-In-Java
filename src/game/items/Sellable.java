package game.items;

import edu.monash.fit2099.engine.items.Item;

public interface Sellable {
    public int getSellPrice();
    public Item sellItem();
}
