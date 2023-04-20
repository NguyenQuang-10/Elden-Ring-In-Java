package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public interface Purchaseable {
    public int getPurchasePrice();
    public WeaponItem purchaseItem();
}
