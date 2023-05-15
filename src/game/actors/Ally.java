package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.archetypes.Archetypes;
import game.behaviours.*;
import game.utils.ArchetypeManager;
import game.utils.Status;

import java.util.*;

/**
 * Ally should not attack the player or other friendly actors (e.g. other Traders or other allies).
 * They can only be removed from the map if the Player dies.
 * If the player rest do not remove them from the map.
 * Ally can not buy or sell items, and cannot interact with sites of lost grace.
 *
 */
public class Ally extends Actor {
    /**
     * A hashmap to store Behaviour according to priority.
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * A public constructor.
     * @param hitPoints The hit points that the ally would have.
     * @param weapon    The initial weapon that would be in the ally's inventory.
     */
    public Ally(int hitPoints, WeaponItem weapon) {
        super("Ally", 'A', hitPoints);
        this.addWeaponToInventory(weapon);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Status.FOLLOWER);

        this.setBehaviour(0, new AllyAttackBehaviour());
        this.setBehaviour(1, new DespawnBehaviour(0));
        this.setBehaviour(2, new WanderBehaviour());
    }

    /**
     * Set behaviours for enemy and its priority
     * @param key the priority of the behaviour
     * @param behaviour the behaviour that determines what action to be performed
     */
    protected void setBehaviour(int key, Behaviour behaviour) {
        this.behaviours.put(key, behaviour);
    }

    /**
     * A getter for behaviours
     * @return the map of Behaviour for the Enemy
     */
    public Map<Integer, Behaviour> getBehaviours() {
        return this.behaviours;
    }

    /**
     * At each turn, this method selects a valid action for the ally to perform.
     * @param actions    Collection of possible Actions for this Actor.
     * @param lastAction The Action this Actor took last turn; this can do interesting things in conjunction with Action.getNextAction().
     * @param map        The map containing the Actor.
     * @param display    The I/O object to which messages may be written.
     * @return The valid action that can be performed in that iteration or null if no valid action is found.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // This play turn returns the action for the next play. Look at the exit if
        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            // Check attack action (ally on perform attack action on an enemy/invader).
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }


}
