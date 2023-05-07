package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * An interface to be implemented by Weapons that can be sold
 * @author AppliedSession03Group03
 */
public interface SellableWeapon {

    /**
     * Gets the price of the weapon for selling
     * @return price of the weapon for selling
     */
    int getSellPrice();
}
