package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.ExchangeableItem;
import game.items.SellableWeapon;
import game.utils.Status;

/**
 * RemembranceOfTheGrafted is an item that can be exchanged for AxeOfGodrick and GraftedDragon Weapons
 */
public class RemembranceOfTheGrafted extends Item implements ExchangeableItem {

    /**
     * A public constructor
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance Of The Grafted", 'O', true);
    }
}
