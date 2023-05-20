package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.PurchaseableWeapon;
import game.items.SellableWeapon;

/**
 * A crossbow, represented by }, carried around by the Godrick soldiers.
 * It deals 64 damage with 57% attack accuracy.
 * @author AppliedSession03Group03
 */
public class HeavyCrossbow extends WeaponItem implements PurchaseableWeapon, SellableWeapon {
    /**
     *  A public constructor
     */
    public HeavyCrossbow() {
        super("HeavyCrossbow", '}', 64, "shoots", 57);
    }

    /**
     * Getter to get the purchase price of the item.
     * @return The purchase price of the item.
     * @see PurchaseableWeapon
     */
    @Override
    public int getPurchasePrice() {
        return 1500;
    }

    /** Instantiate a new instance of the weapon and return it.
     * @return New instance of the club.
     * @see PurchaseableWeapon
     */
    @Override
    public WeaponItem purchaseItem() {
        return new HeavyCrossbow();
    }

    /**
     * Getter to get the sell price of the item.
     * @return The sell price of the item.
     * @see SellableWeapon
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

}
