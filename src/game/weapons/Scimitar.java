package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAllAction;
import game.items.Purchaseable;
import game.items.Sellable;

public class Scimitar extends WeaponItem implements Weapon, Sellable, Purchaseable {
    /**
     * Weapon carried by Bandit Skeleton.
     * It deals 118 damage with 88% hit rate.
     */

    /**
     * Constructor
     */
    public Scimitar() { super("Scimitar", 's', 118, "slashes", 88); }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
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

    @Override
    public WeaponItem purchaseItem() {
        return new Scimitar();
    }

    @Override
    public int getSellPrice() {
        return 100;
    }

    @Override
    public WeaponItem sellItem() {
        return new Scimitar();
    }
}
