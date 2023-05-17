package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAllAction;
import game.items.PurchaseableWeapon;

/**
 * Req 5
 * A Bomb Weapon that has a special skill that can kill all surrounding actors regardless of type
 * instantly. The attacked Actors instantly die regardless their HP value.
 * The special skill can only be used once and the Bomb is removed from the holder's inventory
 *
 * The normal attack instantly kills the target regardless the hp value of target and can only be used
 * once then removed from holder's inventory
 * @author AppliedSession03Group03
 */
public class Bomb extends WeaponItem implements PurchaseableWeapon {

    /**
     * A public constructor
     */

    /**
     * The number of uses left
     */
    private int usesLeft = 1;
    public Bomb() {
        super("Bomb (1) use", 'b', Integer.MAX_VALUE, "bombs", 100);
    }

    /**
     * Getter to get the special skill that this weapon has.
     * @param target Target actor.
     * @param direction The direction relative to the holder.
     * @return The action representing the skill.
     * @see WeaponItem
     */
    public Action getSkill(Actor target, String direction) {
        this.usesLeft -= 1;
        return new AttackAllAction(this);
    }

    /**
     * At every turn checks if Bomb special skill is used or not, if used it is removed from
     * the holder's inventory
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (this.usesLeft < 1) {
            actor.removeWeaponFromInventory(this);
        }
    }

    @Override
    public int damage() {
        this.usesLeft -= 1;
        return super.damage();
    }

    /**
     * Getter to get the purchase price of the item.
     * @return The purchase price of the item.
     * @see PurchaseableWeapon
     */
    @Override
    public int getPurchasePrice() {
        return 1000;
    }

    /** Instantiate a new instance of the weapon and return it.
     * @return New instance of the club.
     * @see PurchaseableWeapon
     */
    @Override
    public WeaponItem purchaseItem() {
        return new Bomb();
    }
}
