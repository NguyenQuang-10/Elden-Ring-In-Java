package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchaseable;
import game.items.Sellable;

public class HeavyCrossbow extends WeaponItem implements Purchaseable, Sellable {
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
