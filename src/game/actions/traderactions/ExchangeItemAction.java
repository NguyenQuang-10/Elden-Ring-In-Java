package game.actions.traderactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * An action used by Player to exchange an Item for a Weapon with Trader
 * @author AppliedSession03Group03
 */
public class ExchangeItemAction extends Action {

    /**
     * The Player's item to be exchanged for a weapon
     */
    private Item actorItem;

    /**
     * The weapon to be received by Player in the exchange
     */
    private WeaponItem returnWeapon;

    /**
     * A public constructor
     * @param actorItem The Player's item to be exchanged for a weapon
     * @param returnWeapon The weapon to be received by Player in the exchange
     */
    public ExchangeItemAction(Item actorItem, WeaponItem returnWeapon) {
        this.actorItem = actorItem;
        this.returnWeapon = returnWeapon;
    }

    /**
     * Remove the item to exchange from the Player and add the weapon to the Player
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String representing the status of the exchange
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this.actorItem);
        actor.addWeaponToInventory(this.returnWeapon);

        return this.actorItem.toString() + " has been exchanged for " + this.returnWeapon.toString();
    }

    /**
     * Returns the menu descriptor of the action
     *
     * @param actor The actor performing the action.
     * @return The menu description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Exchange " + this.actorItem.toString() + " for " + this.returnWeapon.toString();
    }
}
