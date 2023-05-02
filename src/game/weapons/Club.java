package game.weapons;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchaseable;
import game.items.Sellable;

/**
 * A hammer type, represented by ! (the exclamation mark), that deals 103 damage with an 80% hit rate.
 * The Wretch class starts with this weapon.
 * This weapon does not have any special skill.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Arvind Siva
 */
public class Club extends WeaponItem implements Purchaseable, Sellable {
    /**
     * Basic constructor for the weapon.
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    /**
     * This method implements the tick functionality of the game.
     * @param currentLocation The location of the actor carrying this item.
     * @param actor The actor carrying this item.
     * @see WeaponItem
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * Getter to get the purchase price of the item.
     * @return The purchase price of the item
     * @see Purchaseable
     */
    @Override
    public int getPurchasePrice() {
        return 600;
    }

     /**
      * Getter to get the sell price of the item.
      * @return The sell price of the item.
      * @see Sellable
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /** Instantiate a new instance of the weapon and return it.
     * @return New instance of the club.
     * @see Purchaseable
     */
    @Override
    public WeaponItem purchaseItem() {
        return new Club();
    }

    /** Instantiate a new instance of the weapon and return it.
     * @return New instance of the club.
     * @see Sellable
     */
    @Override
    public WeaponItem sellItem() {
        return new Club();
    }
}
