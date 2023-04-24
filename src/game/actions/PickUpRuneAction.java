package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.traderactions.BuySellCapable;
import game.items.Rune;

public class PickUpRuneAction extends PickUpAction {

    private Rune rune;
    private BuySellCapable buyerSeller;
    public PickUpRuneAction(Rune rune, BuySellCapable buyerSeller) {
        super(rune);
        this.rune = rune;
        this.buyerSeller = buyerSeller;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).removeItem(this.rune);
        buyerSeller.addRune(this.rune);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + this.rune;
    }
}
