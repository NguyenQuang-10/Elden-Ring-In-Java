package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.traderactions.BuySellCapable;
import game.items.Rune;
import game.utils.Status;

public class DropRune extends Action {

    private BuySellCapable attacker;
    public DropRune(BuySellCapable attacker) {
        this.attacker = attacker;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        for (Item item: actor.getItemInventory()) {
            if (item.hasCapability(Status.RUNE)) {
                attacker.addRune((Rune) item);
            }
        }
        return "";
    }
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
