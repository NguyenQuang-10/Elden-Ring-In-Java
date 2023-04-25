package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;
import game.utils.FancyMessage;

public class ResetAction extends Action {

    private boolean isDead;

    /**
     * A public constructor
     */
    public ResetAction(boolean isDead) {
        this.isDead = isDead;
    }

    /**
     * Resets the entire game by resetting all the actors and other game elements that need to be
     * reset during a game reset
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return ResetManager.getInstance().run(actor, map);
    }

    /**
     * Describes the game being reset
     * @param actor The actor performing the action.
     * @return A description for menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return this.isDead ? FancyMessage.YOU_DIED : "Game is reset";
    }
}
