package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAllAction;

public class Bomb extends WeaponItem {

    /**
     * Constructor.
     */

    int usesLeft = 1;
    public Bomb() {
        super("Bomb (1) use", 'b', Integer.MAX_VALUE, "bombs", 100);
    }

    public Action getSkill(Actor target, String direction) {
        this.usesLeft -= 1;
        return new AttackAllAction(this);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (this.usesLeft < 1) {
            actor.removeWeaponFromInventory(this);
        }
    }
}
