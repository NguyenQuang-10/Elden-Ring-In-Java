package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAllAction;

import java.util.Random;

public class AttackAllBehaviour implements Behaviour {

    private Random rand = new Random();
    public AttackAllBehaviour() {}

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (rand.nextInt(100) <= 50) {
            return new AttackAllAction();
        }
        return null;
    }
}
