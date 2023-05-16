package game.actors;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.behaviours.*;
import game.reset.ResetManager;
import game.reset.Resettable;
import game.utils.Status;
import java.util.*;

/**
 * This class describes the characteristics and behaviours of Ally.
 * @author AppliedSession03Group03
 * @see Actor
 */
public class Ally extends Actor implements Resettable {
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
        this.addCapability(Status.ALLY);

        this.setBehaviour(0, new AttackBehaviour(false, Status.ALLY));
        this.setBehaviour(1, new DespawnBehaviour(0));
        this.setBehaviour(2, new WanderBehaviour());
    }

    /**
     * Set behaviours for enemy and its priority.
     * @param key The priority of the behaviour.
     * @param behaviour The behaviour that determines what action to be performed.
     */
    protected void setBehaviour(int key, Behaviour behaviour) {
        this.behaviours.put(key, behaviour);
    }

    /**
     * A getter for behaviours.
     * @return The map of Behaviour for the Enemy.
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
        // This play turn returns the action for the next play. Look at the exit if.
        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            // Check attack action (ally on perform attack action on an enemy/invader).
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     *
     * @param actor Actor performing the reset.
     * @param map The game map to reset.
     * @return
     */
    @Override
    public String reset(Actor actor, GameMap map) {
        if (!actor.isConscious()) {
            map.removeActor(this);
            ResetManager.getInstance().removeResettable(this);
            return this + " has been despawned from game ";
        }
        return null;
    }

}
