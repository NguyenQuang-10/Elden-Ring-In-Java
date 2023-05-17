package game.actors.traders;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.BuyerSellerList;
import game.items.ExchangeableItem;
import game.utils.Status;
import game.weapons.*;

import java.util.ArrayList;

/**
 * A new trader, represented by E,
 * which can accept the Remembrance of the Grafted from the player to be exchanged for either
 * the Axe of Godrick or Grafted Dragon.
 *
 * The player cannot purchase weapons from this trader,
 * but they can still sell anything that is sellable to this trader.
 * @author AppliedSession03Group03
 */
public class FingerReaderEnia extends Trader {

    /**
     * The list of items that the player are allowed to exchange
     */
    private ArrayList<ExchangeableItem> exchangeableItems = new ArrayList<>();

    /**
     * A public constructor
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E');

        this.getSellableWeapons().add(new Club());
        this.getSellableWeapons().add(new GreatKnife());
        this.getSellableWeapons().add(new Uchigatana());
        this.getSellableWeapons().add(new Scimitar());
        this.getSellableWeapons().add(new Grossmesser());

        this.exchangeableItems.add(new RemembranceOfTheGrafted());
    }

    /**
     * Returns sell, buy and exchange actions that Player is allowed to perform
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return the empty ActionList
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            for (ExchangeableItem exchangeItem: this.exchangeableItems) {
                actions.add(exchangeItem.getExchangeWeaponAction(otherActor));
            }
        }

        return actions;
    }

}
