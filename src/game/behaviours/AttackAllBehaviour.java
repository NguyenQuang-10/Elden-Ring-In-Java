package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAllAction;

import java.util.Random;

public class AttackAllBehaviour implements Behaviour {

    private Random rand = new Random();
    public AttackAllBehaviour() {}

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);

        if (rand.nextInt(100) <= 50 && isSurroundedByActor(here)) {
            return new AttackAllAction();
        }
        return null;
    }

    public boolean isSurroundedByActor(Location location) {
        Boolean flag = false;
        for (Exit exit: location.getExits()) {
            if (exit.getDestination().containsAnActor()) {
                flag = true;
            }
        }
        return flag;
    }
}
