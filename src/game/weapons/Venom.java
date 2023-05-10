package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AddStatusAction;
import game.items.PurchaseableWeapon;
import game.utils.Status;
import game.utils.WeaponEffect;

public class Venom extends WeaponItem implements PurchaseableWeapon {

    /**
     * Constructor.
     */
    public Venom() {
        super("Venom", 'v', 50, "poisons", 90);
    }

    public Action getSkill(Actor target, String direction) {
        return new AddStatusAction(target, WeaponEffect.POISONED, this);
    }

    @Override
    public int getPurchasePrice() {
        return 500;
    }

    @Override
    public WeaponItem purchaseItem() {
        return new Venom();
    }
}
