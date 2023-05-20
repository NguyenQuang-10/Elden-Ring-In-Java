package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.Random;

/**
 * An action to attack all surrounding actors
 * @author AppliedSession03Group03
 */
public class AttackAllAction extends Action {

    /**
     * Weapon used for the attack
     */
    private Weapon weapon = null;

    /**
     * A public constructor
     */
    public AttackAllAction() {}

    /**
     * A public constructor
     * @param weapon the Weapon used for the attack
     */
    public AttackAllAction(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * When executed, all surrounding actors are attacked and the chance to hit of the weapon that the Actor used
     * is computed to determine whether the actor will hit the target. If so, deal damage to the target and determine
     * whether the target is killed.
     *
     *
     * @param actor The actor performing the attack all action.
     * @param map The map the actor is on.
     * @return the result of the attack, e.g. whether the target is killed, etc.
     * @see DeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " attacks surrounding with " + (weapon != null ? weapon : "Intrinsic Weapon") + "\n";

        Location here = map.locationOf(actor);

        for(Exit exit: here.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                if (target.isConscious())
                    result += retAttackAction(target, actor, exit, map);
            }
        }

        return result;
    }

    /**
     * Describes the actor attacking surrounding with weapon or intrinsic weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks surrounding with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }

    private String retAttackAction(Actor target, Actor actor, Exit exit, GameMap map) {
        String result = "";
        if (weapon == null) {
            result += (new AttackAction(target, exit.getName())).execute(actor, map) + "\n";
        } else {
            result += (new AttackAction(target, exit.getName(), weapon)).execute(actor, map) + "\n";
        }
        return result;
    }
}
