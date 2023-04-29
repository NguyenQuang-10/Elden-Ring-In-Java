package game.reset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Arvind Siva
 * Extra documentation by: Nhat Quang Nguyen
 */
public class ResetManager {
    /**
     * List of Resettable to reset
     * @see Resettable
     */
    final private List<Resettable> resettables;
    /**
     * List of Resettable to remove from the map
     * @see Resettable
     */
    final private List<Resettable> resettablesToRemove;
    /**
     * Singleton instance of the class
     */
    private static ResetManager instance;

    /**
     * Private constructor to enforce use of factory method
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
        this.resettablesToRemove = new ArrayList<>();
    }

    /**
     * Factory method to enforce singleton status
     * @return the instance of the class
     */
    public static ResetManager getInstance() {
        if (instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * Reset the game
     * @param actor the actor performing the reset
     * @param map the game map
     * @return String representing the reset
     */
    public String run(Actor actor, GameMap map) {
        String result = "";
        for (Resettable resettable: this.resettables) {
            result += (resettable.reset(actor, map) + "\n");
        }
        result += "The game has been reset";

        for (Resettable resettable: this.resettablesToRemove) {
            this.resettables.remove(resettable);
        }
        this.resettablesToRemove.clear();
        return result;
    }

    /**
     * Add resettable to be reset upon game reset
     * @param resettable - the resettable to add
     */
    public void registerResettable(Resettable resettable) {
        this.resettables.add(resettable);
    }

    /**
     * Add resettable to be removed from the map upon game reset
     * @param resettable - the resettable to add
     */
    public void removeResettable(Resettable resettable) {
        this.resettablesToRemove.add(resettable);
    }
}
