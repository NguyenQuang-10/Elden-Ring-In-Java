package game.actions.traderactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class ExchangeItemAction extends Action {

    private Item actorItem;
    private WeaponItem returnWeapon;

    public ExchangeItemAction(Item actorItem, WeaponItem returnWeapon) {
        this.actorItem = actorItem;
        this.returnWeapon = returnWeapon;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this.actorItem);
        actor.addWeaponToInventory(this.returnWeapon);

        return this.actorItem.toString() + " has been exchanged for " + this.returnWeapon.toString();
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Exchange " + this.actorItem.toString() + " for " + this.returnWeapon.toString();
    }
}
