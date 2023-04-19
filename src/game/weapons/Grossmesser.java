package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAllAction;

public class Grossmesser extends WeaponItem implements Weapon {
    /**
     * A simple weapon carried by Heavy Skeletal Skeleton.
     * It deals 115 damage with 85% hit rate.
     * Created by:
     * @author Ryan Nguyen
     */

    /**
     * Constructor
     */
    public Grossmesser() { super("Grossmesser", '?', 115, "", 85); } // Need to update for the sound of Grossmesser.

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * This methods implements the spinning attack action that grossmesser has.
     * Created by:
     * @author Ryan Nguyen
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AttackAllAction(this);
    }

}
