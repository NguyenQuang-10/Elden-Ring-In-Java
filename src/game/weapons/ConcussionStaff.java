package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AddWeaponEffectAction;
import game.items.PurchaseableWeapon;
import game.utils.WeaponEffect;

/**
 * Req 5
 * ConcussionStaff has a special skill that makes the target fainted for 3 turns
 * When the target has fainted the target will do nothing
 * Special skill only works on targets who are enemies
 * @author AppliedSession03Group03
 */
public class ConcussionStaff extends WeaponItem implements PurchaseableWeapon {

    /**
     * A public constructor
     */
    public ConcussionStaff() {
        super("Concussion Staff", 'F', 50, "attacks", 90);
    }

    /**
     * Getter to get the special skill that this weapon has.
     * @param target Target actor.
     * @param direction The direction relative to the holder.
     * @return The action representing the skill.
     * @see WeaponItem
     */
    public Action getSkill(Actor target, String direction) {
        return new AddWeaponEffectAction(target, WeaponEffect.FAINTED, this);
    }

    /**
     * Getter to get the purchase price of the item.
     * @return The purchase price of the item.
     * @see PurchaseableWeapon
     */
    @Override
    public int getPurchasePrice() {
        return 5000;
    }

    /** Instantiate a new instance of the weapon and return it.
     * @return New instance of the club.
     * @see PurchaseableWeapon
     */
    @Override
    public WeaponItem purchaseItem() {
        return new ConcussionStaff();
    }
}
