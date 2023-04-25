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
 * A simple weapon that can be used to attack the enemy.
 * It deals 75 damage with 75% hit rate.
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

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    public Action getSkill(Actor target, String direction){
        return new QuickStepAction(this, target, direction);
    }

    @Override
    public int getPurchasePrice() {
        return 3500;
    }

    @Override
    public WeaponItem purchaseItem() {
        return new GreatKnife();
    }

    @Override
    public int getSellPrice() { return 350; }

    @Override
    public WeaponItem sellItem() {
        return new GreatKnife();
    }


}
