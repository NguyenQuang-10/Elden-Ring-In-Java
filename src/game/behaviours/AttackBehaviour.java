package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.actions.DeathAction;
import game.actors.enemies.Enemy;
import game.utils.Status;

import java.util.Random;

public class AttackBehaviour implements Behaviour {

    private Random rand = new Random();
    public AttackBehaviour() {}

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);

        for (Exit exit: here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();

                if (!(rand.nextInt(100) <= 50)
                        && target.isConscious()
                        && target.hasCapability(Status.ENEMY)
                        && !Enemy.isSameEnemy(actor, target)) {
                    return new AttackAction(target, exit.getName());
                }
            }
        }

        return null;
    }
}
