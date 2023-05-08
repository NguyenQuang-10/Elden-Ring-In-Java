package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * An interface to be implemented by Weapons that can be purchased
 * @author AppliedSession03Group03
 */
public interface PurchaseableWeapon {
    /**
     * Gets the price of the weapon for purchase
     * @return price of the weapon for purchase
     */
    int getPurchasePrice();

    /**
     * Returns WeaponItem instance of the weapon to be purchased
     * @return WeaponItem instance of the weapon to be purchased
     */
    WeaponItem purchaseItem();
}
