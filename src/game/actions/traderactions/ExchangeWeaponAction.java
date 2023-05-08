package game.actions.traderactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class ExchangeWeaponAction extends Action {

    private WeaponItem actorWeapon;
    private WeaponItem returnWeapon;

    public ExchangeWeaponAction(WeaponItem actorWeapon, WeaponItem returnWeapon) {
        this.actorWeapon = actorWeapon;
        this.returnWeapon = returnWeapon;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeWeaponFromInventory(this.actorWeapon);
        actor.addWeaponToInventory(this.returnWeapon);

        return this.actorWeapon.toString() + " has been exchanged for " + this.returnWeapon.toString();
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Exchange " + this.actorWeapon.toString() + " for " + this.returnWeapon.toString();
    }
}
