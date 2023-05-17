package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.traderactions.BuySellCapable;
import game.actions.traderactions.ExchangeItemAction;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;

/**
 * An interface to be implemented by Item that can be sold
 * @author AppliedSession03Group03
 */
public interface ExchangeableItem {
    default ActionList getExchangeWeaponAction(Actor actor){
        ActionList actions = new ActionList();
        for (Item item: actor.getItemInventory()) {
            if (this.toString().equals(item.toString())) {
                actions.add(new ExchangeItemAction(item, new AxeOfGodrick()));
                actions.add(new ExchangeItemAction(item, new GraftedDragon()));
                break;
            }
        }
        return actions;
    }
}
