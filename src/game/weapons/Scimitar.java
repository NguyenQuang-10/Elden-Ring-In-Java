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
 * with 88% accuracy.
 * This sword allows the user to attack a single enemy within their surroundings or to perform a spinning attack,
 * which attack all creatures, including the player, within the user’s surroundings. The damage dealt and the attack
 * accuracy for the targeted and the spinning attack are the same.
 * Note that since the spinning attack hits anything in the user’s surroundings, it may hit other actors of the
 * same type.
 * If the user performs the spinning attack, actor A may get hit while actor B may not (the probability is
 * independent between each actor, i.e. one actor getting hit does not mean another actor will also get hit)
 * This weapon can be purchased from Merchant Kale for 600 runes.
 * If this weapon is available in the player's weapon inventory, this weapon can be sold for 100 runes.
 * Edit: Scimitar will be dropped by Skeletal Bandit when they are defeated by the player
 * (after the pile of bones is destroyed).
 */
public class Scimitar extends WeaponItem implements Weapon, Sellable, Purchaseable {

    /**
     * Constructor
     */
    public Scimitar() { super("Scimitar", 's', 118, "slashes", 88); }

    /** @see WeaponItem
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /** @see Weapon
     * @param holder the actor holding  the weapon
     * This methods implements the spinning attack action that grossmesser has.
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AttackAllAction(this);
    }

    @Override
    public int getPurchasePrice() {
        return 600;
    }

    /** Instatiate a new instance of the weapon and return it
     * @see Purchaseable
     * @return new instance of the club
     */
    @Override
    public WeaponItem purchaseItem() {
        return new Scimitar();
    }

    /** @see Sellable
     *
     * @return the sell price of the item
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /** Instatiate a new instance of the weapon and return it
     * @see Sellable
     * @return new instance of the club
     */
    @Override
    public WeaponItem sellItem() {
        return new Scimitar();
    }
}
