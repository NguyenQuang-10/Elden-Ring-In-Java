package game.reset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 * Created by:
 * @author Adrian Kristanto
 * Modified by: AppliedSession03Group03
 *
 */
public interface Resettable {
    /**
     * Resets the game
     * @param actor - actor performing the reset
     * @param map - the game map to reset
     * @return String representing the reset
     */
     String reset(Actor actor, GameMap map);
}
