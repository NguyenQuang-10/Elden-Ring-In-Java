package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.SellableWeapon;

public class AxeOfGodrick extends WeaponItem implements SellableWeapon {
    /**
     * Constructor.
     *
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "slash", 84);
    }

    @Override
    public int getSellPrice() {
        return 100;
    }
}
