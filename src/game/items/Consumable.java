package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.ConsumeAction;

public interface Consumable {
    int getUsesLeft();
    ConsumeAction getConsumeAction();
    void consumedBy(Actor actor);
    String getName();
    String getEffect();

}
