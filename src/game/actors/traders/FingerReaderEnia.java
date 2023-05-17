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

public class FingerReaderEnia extends Trader {
    /**
     * Constructor.
     */

    private ArrayList<ExchangeableItem> exchangeableItems = new ArrayList<>();
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E');

        this.getSellableWeapons().add(new Club());
        this.getSellableWeapons().add(new GreatKnife());
        this.getSellableWeapons().add(new Uchigatana());
        this.getSellableWeapons().add(new Scimitar());
        this.getSellableWeapons().add(new Grossmesser());

        this.exchangeableItems.add(new RemembranceOfTheGrafted());
    }

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
