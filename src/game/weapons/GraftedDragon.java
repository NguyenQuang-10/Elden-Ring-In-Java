package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.SellableWeapon;
import game.utils.Status;

public class GraftedDragon extends WeaponItem implements SellableWeapon {
    /**
     * Constructor.
     *
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "slash", 90);
    }

    @Override
    public int getSellPrice() {
        return 200;
    }
}
