package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.SellableWeapon;
import game.utils.Status;

public class RemembranceOfTheGrafted extends WeaponItem implements SellableWeapon {
    /**
     * Constructor.

     */
    public RemembranceOfTheGrafted() {
        super("Remembrance Of The Grafted", 'O', 0, "", 0);
        this.addCapability(Status.EXCHANGEABLE);
    }

    @Override
    public int getSellPrice() {
        return 20000;
    }
}
