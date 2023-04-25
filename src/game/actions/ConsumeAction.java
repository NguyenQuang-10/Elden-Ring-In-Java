package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

public class ConsumeAction extends Action {
    final private Consumable consumable;

    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        consumable.consumedBy(actor);
        return actor.toString() + " has consumed " + consumable.getName() + "\n" + consumable.getEffect();
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Consume " + this.consumable.getName() + " (" + this.consumable.getUsesLeft() + " uses left)";
    }
}
