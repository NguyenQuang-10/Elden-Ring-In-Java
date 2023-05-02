package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAllAction;
import game.items.Purchaseable;
import game.items.Sellable;

/**
 * A curved sword, represented by s (lowercase S), carried around by the Skeletal Bandit that deals 118 damage
 * with 88% accuracy. This sword allows the user to attack a single enemy within their surroundings or to perform a
 * spinning attack, which attack all creatures, including the player, within the user’s surroundings. The damage dealt
 * and the attack accuracy for the targeted and the spinning attack are the same. Note that since the spinning attack
 * hits anything in the user’s surroundings, it may hit other actors of the same type. If the user performs the spinning
 * attack, actor A may get hit while actor B may not (the probability is independent between each actor, i.e. one actor
 * getting hit does not mean another actor will also get hit). This weapon can be purchased from Merchant Kale for 600
 * runes. If this weapon is available in the player's weapon inventory, this weapon can be sold for 100 runes.
 * Edit: Scimitar will be dropped by Skeletal Bandit when they are defeated by the player (after the pile of bones is
 * destroyed).
 * @author AppliedSession03Group03
 * @see WeaponItem
 */
public class Scimitar extends WeaponItem implements Weapon, Sellable, Purchaseable {

    /**
     * Basic constructor for the weapon.
     */
    public Scimitar() { super("Scimitar", 's', 118, "slashes", 88); }

    /**
     * This method implements the tick functionality of the game.
     * @param currentLocation The location of the actor carrying this item.
     * @param actor The actor carrying this item.
     * @see WeaponItem
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * This method implements the spinning attack action that Grossmesser has.
     * @param holder The actor holding the weapon.
     * @see Weapon
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AttackAllAction(this);
    }

    /**
     * Getter to get the purchasing price of the weapon.
     * @return The purchasing price of the weapon.
     * @see Purchaseable
     */
    @Override
    public int getPurchasePrice() {
        return 600;
    }

    /** Instantiate a new instance of the weapon and return it.
     * @return New instance of the club.
     * @see Purchaseable
     */
    @Override
    public WeaponItem purchaseItem() {
        return new Scimitar();
    }

    /**
     * Getter to get the sell price of the weapon.
     * @return The sell price of the item.
     * @see Sellable
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /** Instantiate a new instance of the weapon and return it.
     * @see Sellable
     * @return New instance of the weapon.
     */
    @Override
    public WeaponItem sellItem() {
        return new Scimitar();
    }
}
