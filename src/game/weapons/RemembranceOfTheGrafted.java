package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.SellableWeapon;
import game.utils.Status;

public class RemembranceOfTheGrafted extends WeaponItem implements SellableWeapon {
    /**
     * Constructor.

     */
    public RemembranceOfTheGrafted() {
        super("Godrick the Grafted", 'O', 10, "slash", 75);
        this.addCapability(Status.EXCHANGEABLE);
    }

    @Override
    public int getSellPrice() {
        return 20000;
    }
}
