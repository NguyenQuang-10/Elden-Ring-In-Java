package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchaseable;
import game.items.Sellable;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 115 damage with 80% attack accuracy.
 * Created by:
 * @author Ryan Nguyen
 */
public class Uchigatana extends WeaponItem implements Purchaseable, Sellable {

    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "", 80);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
    *
     */
//    @Override
//    public Action getSkill(Actor target, String direction){
//        return new UnseatheAction(target, direction);
//    }

    @Override
    public int getPurchasePrice() {
        return 5000;
    }

    @Override
    public int getSellPrice() { return 500; }

    @Override
    public WeaponItem purchaseItem() {
        return new Uchigatana();
    }

    @Override
    public WeaponItem sellItem() {
        return new Uchigatana();
    }
}
