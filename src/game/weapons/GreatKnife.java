package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.QuickStepAction;
import game.actions.UnseatheAction;
import game.items.Purchaseable;
import game.items.Sellable;

/**
 * A dagger type, represented by / (the forward slash), that deals 75 damage with a 70% hit rate.
 * This is the starting weapon of the Bandit class.
 * This weapon allows the user to perform "Quickstep", a unique skill that deals normal damage to the weapon to the enemy
 * Created by:
 * @author Ryan Nguyen
 */
public class GreatKnife extends WeaponItem implements Purchaseable, Sellable {

    /**
     * Constructor
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "slash", 70);
    }

    /** @see WeaponItem
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /** @see edu.monash.fit2099.engine.weapons.Weapon
     * Get the special skill that this weapon has
     * @param target target actor
     * @param direction the direction relative to the holder
     * @return the action representing the skill
     */
    public Action getSkill(Actor target, String direction){
        return new QuickStepAction(this, target, direction);
    }

    /** @see Purchaseable
     *
     * @return the purchase price of the item
     */
    @Override
    public int getPurchasePrice() {
        return 3500;
    }

    /** Instatiate a new instance of the weapon and return it
     * @see Purchaseable
     * @return new instance of the club
     */
    @Override
    public WeaponItem purchaseItem() {
        return new GreatKnife();
    }

    /** @see Sellable
     *
     * @return the sell price of the item
     */
    @Override
    public int getSellPrice() { return 350; }

    /** Instatiate a new instance of the weapon and return it
     * @see Sellable
     * @return new instance of the club
     */
    @Override
    public WeaponItem sellItem() {
        return new GreatKnife();
    }


}
