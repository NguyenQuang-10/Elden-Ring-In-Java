package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;

public class FlaskConsumeAction extends Action {
    private FlaskOfCrimsonTears flaskOfCrimsonTear;

    public FlaskConsumeAction(FlaskOfCrimsonTears flaskOfCrimsonTear) {
        this.flaskOfCrimsonTear = flaskOfCrimsonTear;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.isConscious()) {
            this.flaskOfCrimsonTear.used();
            actor.heal(250);
            return "Consumed Flask of Crimson Tears. Healed by 250 points";
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Consume Flask of Crimson Tear (" + flaskOfCrimsonTear.getUsesLeft() + "/2 uses left)";
    }
}
