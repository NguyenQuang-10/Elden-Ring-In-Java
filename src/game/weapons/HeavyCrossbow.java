package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.PurchaseableWeapon;
import game.items.SellableWeapon;

public class HeavyCrossbow extends WeaponItem implements PurchaseableWeapon, SellableWeapon {
    /**
     * Constructor.
     *
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

    @Override
    public WeaponItem sellItem() {
        return this;
    }
}
