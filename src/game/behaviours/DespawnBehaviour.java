package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAllAction;
import game.actions.DespawnAction;

import java.util.Random;

public class DespawnBehaviour implements Behaviour{

    private Random rand = new Random();
    private int despawnProb;

    public DespawnBehaviour(int despawnProb) {
        this.despawnProb = despawnProb;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (rand.nextInt(100) <= despawnProb) {
            return new DespawnAction();
        }
        return null;
    }
}
