package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.behaviours.*;
import game.items.Rune;
import game.reset.ResetManager;
import game.reset.Resettable;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;

import static game.actors.enemies.EnemyType.*;

public abstract class Enemy extends Actor implements Resettable {

    /**
     * A hashmap to store Behaviour according to priority
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * A public constructor
     * @param name the name of the Enemy
     * @param displayChar the character that will represent the Enemy in the display
     * @param hitPoints the Enemy's starting hit points
     * @param enemyType the type of the Enemy
     */
    public Enemy(String name, char displayChar, int hitPoints, EnemyType enemyType) {
        super(name, displayChar, hitPoints);
        this.maxHitPoints = hitPoints;
        this.addCapability(Status.ENEMY);
        this.addCapability(Status.SPAWNABLE);
        this.addCapability(enemyType);
        ResetManager.getInstance().registerResettable(this);

    }

    protected void setBehaviour(int key, Behaviour behaviour) {
        this.behaviours.put(key, behaviour);
    }



    /**
     * A getter for behaviours
     * @return the list of Behaviour for the Enemy
     */
    public Map<Integer, Behaviour> getBehaviours() {
        return this.behaviours;
    }

    /**
     * Add Rune to the Enemy which will be dropped when Enemy is killed
     * @param min The min value of the Rune
     * @param max The max value of the Rune
     */
    public void addRune(int min, int max) {
        this.addItemToInventory(new Rune(min, max));
    }

    /**
     * Checks if the 2 Actor are the same type of Enemy
     * @param actor1 An actor
     * @param actor2 An actor
     * @return true if the actors are same Enemy type else false
     */
    public static boolean isSameEnemy(Actor actor1, Actor actor2) {
        if (actor1.hasCapability(SKELETON) && actor2.hasCapability(SKELETON)) {
            return true;
        } else if (actor1.hasCapability(FOURLEGANIMAL) && actor2.hasCapability(FOURLEGANIMAL)) {
            return true;
        } else if (actor1.hasCapability(SEAANIMAL) && actor2.hasCapability(SEAANIMAL)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * The Enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability and
     * if the Enemy is conscious
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A list of actions that are allowed to be performed by otherActor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (this.isConscious()) {
            if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                actions.add(new AttackAction(this, direction));
                for (Weapon weapon: otherActor.getWeaponInventory()) {
                    actions.add(new AttackAction(this, direction, weapon));
                    actions.add(weapon.getSkill(otherActor));
                    actions.add(weapon.getSkill(this, direction));
                }
            }
        }
        return actions;
    }

    /**
     * Removes spawnable Enemy from the game when reset
     * @param actor the Actor that triggered an entire game reset
     * @param map current GameMap
     * @return A description of the reset process
     */
    public String reset(Actor actor, GameMap map) {
        if (this.hasCapability(Status.SPAWNABLE)) {
            map.removeActor(this);
            ResetManager.getInstance().removeResettable(this);
            return this + " has been despawned from game ";
        }
        return null;
    }

    /**
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the action to execute
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(FOLLOWER)) {
            Location here = map.locationOf(this);
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();
                if (map.isAnActorAt(destination) && map.getActorAt(destination).hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    this.setBehaviour(1, new FollowBehaviour(map.getActorAt(destination)));
                    break;
                }
            }
        }

        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();

    }
}
