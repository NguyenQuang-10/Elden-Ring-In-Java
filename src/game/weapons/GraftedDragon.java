package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.SellableWeapon;
import game.utils.Status;

/**
 * Grafted Dragon deals 89 damage with 90% attack accuracy
 * @author AppliedSession03Group03
 */
public class GraftedDragon extends WeaponItem implements SellableWeapon {
    /**
     * A public constructor
     *
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "slash", 90);
    }

    /**
     * Getter to get the sell price of the item.
     * @return The sell price of the item.
     * @see SellableWeapon
     */
    @Override
    public int getSellPrice() {
        return 200;
    }
}
