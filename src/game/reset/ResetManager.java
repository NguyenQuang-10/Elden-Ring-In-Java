package game.reset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Arvind Siva
 *
 */
public class ResetManager {
    private List<Resettable> resettables;
    private List<Resettable> resettablesToRemove;
    private static ResetManager instance;

    /**
     * HINT 1: where have we seen a private constructor before?
     * HINT 2: see the instance attribute above.
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
        this.resettablesToRemove = new ArrayList<>();
    }

    public static ResetManager getInstance() {
        if (instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }

    public String run(Actor actor, GameMap map) {
        String result = "";
        for (Resettable resettable: this.resettables) {
            result += (resettable.reset(actor, map) + "\n");
        }
        result += "The game has been reset";

        for (Resettable resettable: this.resettablesToRemove) {
            this.resettables.remove(resettable);
        }
        return result;
    }

    public void registerResettable(Resettable resettable) {
        this.resettables.add(resettable);
    }

    public void removeResettable(Resettable resettable) {
        this.resettablesToRemove.add(resettable);
    }
}
