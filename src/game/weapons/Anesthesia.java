package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class Anesthesia extends WeaponItem {

    /**
     * Constructor.
     */
    public Anesthesia() {
        super("Anesthesia", 'F', 50, "paralyses", 90);
    }

    public Action getSkill(Actor target, String direction) {
        target.addCapability(Status.FAINTED);
        return null;
    }
}
