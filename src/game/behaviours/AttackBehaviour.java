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


/**
 * A behaviour that determines whether an Actor performs AttackAction to attack a single target
 * or attack all actors in its surrounding using AttackAllAction
 * @author AppliedSession03Group03
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Determines whether the Actor could perform surrounding attack
     * true if attack surrounding is allowed else false
     */
    final private boolean canAttackAll;
    final private Status attackerType;

    /**
     * A public constructor
     * @param canAttackAll Determines whether the Actor could perform surrounding attack
     */
    public AttackBehaviour(boolean canAttackAll, Status attackerType) {
        this.canAttackAll = canAttackAll;
        this.attackerType = attackerType;
    }

    /**
     * Decides whether the Actor should perform a single targeted attack or a surrounding
     * attack or not attack at all
     * 50% chance to attack surrounding of the actor is allowed to and surrounded by actors
     * 50% chance for targeted attack to attack single actor
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return AttackAction or AttackAllAction or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);

        if (RandomNumberGenerator.getRandomInt(1, 100) <= 50
                && hasEnemyAdjacent(actor,here, map)
                && this.canAttackAll) {
            return retAttackAllAction(actor);
        }

        for (Exit exit: here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();

                if (determineTargets(actor, target)) {
                    return retAttackAction(actor, target, exit);
                }
            }
        }

        return null;
    }

    private boolean determineTargets(Actor attacker, Actor target) {
        if (this.attackerType == Status.ENEMY) {
            return target.isConscious()
                    && !Enemy.isSameEnemy(attacker, target);
        } else if (this.attackerType == Status.ALLY) {
            return target.isConscious()
                    && (target.hasCapability(Status.ENEMY) || target.hasCapability(Status.INVADER));
        } else {
            return target.isConscious()
                    && (target.hasCapability(Status.HOSTILE_TO_ENEMY) || target.hasCapability(Status.ENEMY)
                    || target.hasCapability(Status.ALLY));
        }
    }

    /**
     * Checks if there are Actors in surrounding
     * @param location current location of the Actor
     * @return true if surrounded by Actors else false
     */
    private boolean hasEnemyAdjacent(Actor actor, Location location, GameMap map) {
        boolean flag = false;
        for (Exit exit: location.getExits()) {
            if (exit.getDestination().containsAnActor()) {
                Actor adjacentActor = map.getActorAt(exit.getDestination());
                if (!Enemy.isSameEnemy(actor, adjacentActor) || adjacentActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private Action retAttackAllAction(Actor attacker) {
        int numOfWeapons = attacker.getWeaponInventory().size();
        if (numOfWeapons >= 1) {
            Weapon weapon = attacker.getWeaponInventory().get(0);
            if (RandomNumberGenerator.getRandomInt(1, 100) <= 50) {
                return weapon.getSkill(attacker);
            }
            return new AttackAllAction(attacker.getWeaponInventory().get(0));
        }
        else {
            return new AttackAllAction();
        }
    }

    private Action retAttackAction(Actor attacker, Actor target, Exit exit) {
        int numOfWeapons = attacker.getWeaponInventory().size();

        if (numOfWeapons >= 1) {

            Weapon weapon = attacker.getWeaponInventory().get(0);
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
