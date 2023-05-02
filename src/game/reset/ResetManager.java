package game.reset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: AppliedSession03Group03
 */
public class ResetManager {
    /**
     * List of Resettable to reset
     * @see Resettable
     */
    final private List<Resettable> resettables;
    /**
     * List of Resettable to remove from the list after reset
     * @see Resettable
     */
    final private List<Resettable> resettablesToRemove;

    /**
     * List of Resettable to add to the list after reset
     * @see Resettable
     */
    final private List<Resettable> resettablesToAdd;

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
        this.resettablesToAdd = new ArrayList<>();
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

        for (Resettable resettable: this.resettablesToAdd) {
            this.resettables.add(0, resettable);
        }

        this.resettablesToAdd.clear();

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
     * Add resettable to be add to the resettable list after reset
     * @param resettable - the resettable to add
     */
    public void registerResettableAfterReset(Resettable resettable) {
        this.resettablesToAdd.add(resettable);
    }

    /**
     * Add resettable to be removed from the resettable list
     * @param resettable - the resettable to add
     */
    public void removeResettable(Resettable resettable) {
        this.resettablesToRemove.add(resettable);
    }
}
