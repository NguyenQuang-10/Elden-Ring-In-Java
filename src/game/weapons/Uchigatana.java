package game.weapons;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchaseable;
import game.items.Sellable;
import game.actions.UnseatheAction;

/**
 * A katana type, represented by ")" (the close parenthesis), that is a starting weapon of the Samurai class. It deals
 * 115 damage with 80% attack accuracy. This weapon allows the user to perform "Unsheathe", a unique skill that deals 2x
 * damage from the weapon with a 60% chance to hit the enemy.
 * Created by:
 * @author Ryan Nguyen
 * @version JDK 20
 * @see WeaponItem
 */
public class Uchigatana extends WeaponItem implements Purchaseable, Sellable {
    /**
     * Basic constructor for the weapon.
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "bash", 80);
    }

    /** @see edu.monash.fit2099.engine.weapons.Weapon
     * Get the special skill that this weapon has, i.e. unseathe.
     * @param target Target actor.
     * @param direction The direction relative to the holder.
     * @return The action representing the skill.
     */
    @Override
    public Action getSkill(Actor target, String direction){
        return new UnseatheAction(target, direction, this);
    }

    /**
     * Getter to return the price to purchase the Uchigatana.
     * @see Purchaseable
     * @return the purchase price of the item.
     */
    @Override
    public int getPurchasePrice() {
        return 5000;
    }

    /**
     * Getter to return the price when selling the Uchigatana.
     * @return The sell price of the item.
     * @see Sellable
     */
    @Override
    public int getSellPrice() { return 500; }

    /** Instantiate a new instance of the weapon and return it.
     * @see Purchaseable
     * @return New instance of the club.
     */
    @Override
    public WeaponItem purchaseItem() {
        return new Uchigatana();
    }

    /** Instantiate a new instance of the weapon and return it.
     * @see Sellable
     * @return New instance of the club.
     */
    @Override
    public WeaponItem sellItem() {
        return new Uchigatana();
    }
}
