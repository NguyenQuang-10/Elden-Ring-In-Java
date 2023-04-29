package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchaseable;
import game.items.Sellable;
import game.actions.UnseatheAction;

/**
 * A katana type, represented by ) (the close parenthesis), that is a starting weapon of the Samurai class.
 * It deals 115 damage with 80% attack accuracy.
 * This weapon allows the user to perform "Unsheathe", a unique skill that deals 2x damage of the weapon with a
 * 60% chance to hit the enemy.
 * Created by:
 * @author Ryan Nguyen
 */
public class Uchigatana extends WeaponItem implements Purchaseable, Sellable {

    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "bash", 80);
    }

    /** @see edu.monash.fit2099.engine.weapons.Weapon
     * Get the special skill that this weapon has
     * @param target target actor
     * @param direction the direction relative to the holder
     * @return the action representing the skill
     */
    @Override
    public Action getSkill(Actor target, String direction){
        return new UnseatheAction(target, direction, this);
    }

    /** @see Purchaseable
     *
     * @return the purchase price of the item
     */
    @Override
    public int getPurchasePrice() {
        return 5000;
    }

    /** @see Sellable
     *
     * @return the sell price of the item
     */
    @Override
    public int getSellPrice() { return 500; }

    /** Instatiate a new instance of the weapon and return it
     * @see Purchaseable
     * @return new instance of the club
     */
    @Override
    public WeaponItem purchaseItem() {
        return new Uchigatana();
    }

    /** Instatiate a new instance of the weapon and return it
     * @see Sellable
     * @return new instance of the club
     */
    @Override
    public WeaponItem sellItem() {
        return new Uchigatana();
    }
}
