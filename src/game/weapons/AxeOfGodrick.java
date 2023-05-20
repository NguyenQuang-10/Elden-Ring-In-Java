package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.SellableWeapon;

/**
 * Axe of Godrick deals 142 damage with 84% attack accuracy.
 * @author AppliedSession03Group03
 */
public class AxeOfGodrick extends WeaponItem implements SellableWeapon {
    /**
     * A public constructor
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "slash", 84);
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
