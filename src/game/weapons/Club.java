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
 *
 */
public class Club extends WeaponItem implements Purchaseable, Sellable {

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    /** @see WeaponItem
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /** @see Purchaseable
     *
     * @return the purchase price of the item
     */
    @Override
    public int getPurchasePrice() {
        return 600;
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
     * @see Purchaseable
     * @return new instance of the club
     */
    @Override
    public WeaponItem purchaseItem() {
        return new Club();
    }

    /** Instatiate a new instance of the weapon and return it
     * @see Sellable
     * @return new instance of the club
     */
    @Override
    public WeaponItem sellItem() {
        return new Club();
    }

}
