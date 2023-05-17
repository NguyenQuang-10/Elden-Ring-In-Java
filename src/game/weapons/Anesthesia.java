package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AddWeaponEffectAction;
import game.items.PurchaseableWeapon;
import game.utils.WeaponEffect;

public class Anesthesia extends WeaponItem implements PurchaseableWeapon {

    /**
     * Constructor.
     */
    public Anesthesia() {
        super("Anesthesia", 'F', 50, "attacks", 90);
    }

    public Action getSkill(Actor target, String direction) {
        return new AddWeaponEffectAction(target, WeaponEffect.FAINTED, this);
    }

    @Override
    public int getPurchasePrice() {
        return 500;
    }

    @Override
    public WeaponItem purchaseItem() {
        return new Anesthesia();
    }
}
