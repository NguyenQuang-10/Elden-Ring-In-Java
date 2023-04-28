package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actions.AttackAllAction;
import game.actors.enemies.Enemy;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.Random;

/**
 * A behaviour that determines whether an Actor performs AttackAction to attack a single target
 * or attack all actors in its surrounding using AttackAllAction
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Determines whether the Actor could perform surrounding attack
     * true if attack surrounding is allowed else false
     */
    private boolean canAttackAll;

    /**
     * A public constructor
     * @param canAttackAll Determines whether the Actor could perform surrounding attack
     */
    public AttackBehaviour(boolean canAttackAll) {
        this.canAttackAll = canAttackAll;
    }

    /**
     * Decides whether the Actor should perform a single targeted attack or a surrounding
     * attack or not attack at all
     *
     * 50% chance to attack surrounding of the actor is allowed to and surrounded by actors
     * 50% chance for targeted attack to attack single actor
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);

        if (RandomNumberGenerator.getRandomInt(1, 100) <= 50
                && isSurroundedByActor(here)
                && this.canAttackAll) {
            int numOfWeapons = actor.getWeaponInventory().size();
            if (numOfWeapons >= 1) {
                Weapon weapon = actor.getWeaponInventory().get(0);
                if (RandomNumberGenerator.getRandomInt(1, 100) <= 50) {
                    return weapon.getSkill(actor);
                }
                return new AttackAllAction(actor.getWeaponInventory().get(0));
            }
            else {
                return new AttackAllAction();
            }
        }

        for (Exit exit: here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();

                if (target.isConscious()
                        && (target.hasCapability(Status.ENEMY) || target.hasCapability(Status.HOSTILE_TO_ENEMY))
                        && !Enemy.isSameEnemy(actor, target)) {

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

    /**
     * Checks if there are Actors in surrounding
     * @param location current location of the Actor
     * @return true if surrounded by Actors else false
     */
    private boolean isSurroundedByActor(Location location) {
        Boolean flag = false;
        for (Exit exit: location.getExits()) {
            if (exit.getDestination().containsAnActor()) {
                flag = true;
            }
        }
        return flag;
    }
}
