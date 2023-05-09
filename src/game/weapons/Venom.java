package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class Venom extends WeaponItem {

    /**
     * Constructor.
     */
    public Venom() {
        super("Venom", 'v', 50, "poisons", 90);
    }

    public Action getSkill(Actor target, String direction) {
        target.addCapability(Status.POISONED);
        return null;
    }
}
