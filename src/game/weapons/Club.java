package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchaseable;
import game.items.Sellable;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
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

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    @Override
    public int getPurchasePrice() {
        return 600;
    }

    @Override
    public int getSellPrice() {
        return 100;
    }

    @Override
    public Item purchaseItem() {
        return new Club();
    }

    @Override
    public Item sellItem() {
        return new Club();
    }

}
