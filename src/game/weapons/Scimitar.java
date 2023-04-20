package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAllAction;

public class Scimitar extends WeaponItem implements Weapon {
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

}
