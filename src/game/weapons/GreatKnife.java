package game.weapons;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.QuickStepAction;
import game.items.Purchaseable;
import game.items.Sellable;

/**
 * A dagger type, represented by / (the forward slash), that deals 75 damage with a 70% hit rate. This is the starting
 * weapon of the Bandit class. This weapon allows the user to perform "Quickstep", a unique skill that deals normal
 * damage to the weapon to the enemy.
 * Created by:
 * @author AppliedSession03Group03
 * @see WeaponItem
 */
public class GreatKnife extends WeaponItem implements Purchaseable, Sellable {
    /**
     * Basic constructor for the weapon.
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "slash", 70);
    }

    /**
     * This method implements the tick functionality of the game.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     * @see WeaponItem
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * Getter to get the special skill that this weapon has.
     * @param target Target actor.
     * @param direction The direction relative to the holder.
     * @return The action representing the skill.
     * @see WeaponItem
     */
    public Action getSkill(Actor target, String direction){
        return new QuickStepAction(this, target, direction);
    }

    /**
     * Getter to get the purchase price of the item.
     * @return The purchase price of the item.
     * @see Purchaseable
     */
    @Override
    public int getPurchasePrice() {
        return 3500;
    }

    /** Instantiate a new instance of the weapon and return it.
     * @return New instance of the club.
     * @see Purchaseable
     */
    @Override
    public WeaponItem purchaseItem() {
        return new GreatKnife();
    }

    /**
     * Getter to get the sell price of the item.
     * @return The sell price of the item.
     * @see Sellable
     */
    @Override
    public int getSellPrice() { return 350; }

    /** Instantiate a new instance of the weapon and return it.
     * @return New instance of the club.
     * @see Sellable
     */
    @Override
    public WeaponItem sellItem() {
        return new GreatKnife();
    }
}
