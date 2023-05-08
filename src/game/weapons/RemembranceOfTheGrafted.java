package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.SellableWeapon;

public class RemembranceOfTheGrafted extends WeaponItem implements SellableWeapon {
    /**
     * Constructor.

     */
    public RemembranceOfTheGrafted() {
        super("Godrick the Grafted", 'O', 10, "slash", 75);
    }

    @Override
    public int getSellPrice() {
        return 20000;
    }
}
