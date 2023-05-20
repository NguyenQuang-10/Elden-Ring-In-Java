package game.actors.traders;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.ExchangeableItem;
import game.items.RemembranceOfTheGrafted;
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
     * A public constructor
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E');

        this.getSellableWeapons().add(new Club());
        this.getSellableWeapons().add(new GreatKnife());
        this.getSellableWeapons().add(new Uchigatana());
        this.getSellableWeapons().add(new Scimitar());
        this.getSellableWeapons().add(new Grossmesser());

        this.getExchangeableItems().add(new RemembranceOfTheGrafted());
    }
}
