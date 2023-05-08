package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderactions.BuySellCapable;
import game.actions.traderactions.SellWeaponAction;

/**
 * An interface to be implemented by Weapons that can be sold
 * @author AppliedSession03Group03
 */
public interface SellableWeapon {

    /**
     * Gets the price of the weapon for selling
     * @return price of the weapon for selling
     */
    int getSellPrice();

    default Action getSellWeaponAction(Actor actor, BuySellCapable seller){
        for (WeaponItem weapon: actor.getWeaponInventory()) {
            if (this.toString().equals(weapon.toString())) {
                return new SellWeaponAction(weapon, this.getSellPrice(), seller);
            }
        }
        return null;
    }
}
