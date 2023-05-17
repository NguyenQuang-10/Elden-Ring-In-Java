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

    @Override
    public int getPurchasePrice() {
        return 1500;
    }

    @Override
    public WeaponItem purchaseItem() {
        return new HeavyCrossbow();
    }

    @Override
    public int getSellPrice() {
        return 100;
    }

}
