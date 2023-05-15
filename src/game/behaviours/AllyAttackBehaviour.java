package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actors.enemies.Enemy;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * Ally should attack enemies and invaders.
 */
public class AllyAttackBehaviour implements Behaviour {
    public AllyAttackBehaviour(){}

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit: here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();

                if (target.isConscious()
                        && (target.hasCapability(Status.ENEMY) || target.hasCapability(Status.INVADER))){

                    int numOfWeapons = actor.getWeaponInventory().size();

                    if (numOfWeapons >= 1) {

                        Weapon weapon = actor.getWeaponInventory().get(0);
                        if (RandomNumberGenerator.getRandomInt(1, 100) <= 50
                                && weapon.getSkill(target, exit.getName()) != null) {
                            return weapon.getSkill(target, exit.getName());
                        }

                        return new AttackAction(target, exit.getName(), weapon);
                    }
                    else {
                        return new AttackAction(target, exit.getName());
                    }
                }
            }
        }

        return null;
    }
}
