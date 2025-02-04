package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;
import game.utils.FancyMessage;

/**
 * Resets the entire game by executing reset methods of actors and game elements that
 * need to be reset when the game is reset
 *
 * @author AppliedSession03Group03
 */
public class ResetAction extends Action {

    /**
     * A public constructor
     */
    public ResetAction() {}

    /**
     * Resets the entire game by resetting all the actors and other game elements that need to be
     * reset during a game reset
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = !actor.isConscious() ? FancyMessage.YOU_DIED + "\n" : "";
        result += ResetManager.getInstance().run(actor, map);
        return result;
    }

    /**
     * Describes the game being reset
     * @param actor The actor performing the action.
     * @return A description for menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Game is reset";
    }
}
