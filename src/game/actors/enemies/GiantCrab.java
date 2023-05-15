package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.*;
import game.utils.Status;

import java.util.ArrayList;

/**
 * Giant Crab enemy, hostile creature, represented by C (uppercase C),
 * that has 407 hit points and slams other creatures, including the player,
 * dealing 208 damage with 90% attack accuracy
 * @author AppliedSession03Group03
 */
public class GiantCrab extends Enemy {

    /**
     * A public constructor
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407, EnemyType.SEAANIMAL);
        this.addRune(318, 4961);
        this.addCapability(Status.FOLLOWER);

        // add weapon effect behaviour

        this.setBehaviour(0, new WeaponEffectBehaviour());
        this.setBehaviour(1, new AttackBehaviour(true));

        // behaviour at key 2 is reserved for follow behaviour

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.setBehaviour(i+3, behaviours.get(i));
        }
    }

    /**
     * Determines the action to execute at current turn
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the action to execute
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.FOLLOWER)) {
            Location here = map.locationOf(this);
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();
                if (map.isAnActorAt(destination) && map.getActorAt(destination).hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    this.setBehaviour(2, new FollowBehaviour(map.getActorAt(destination)));
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

    /**
     * Returns the default attack capability of GiantCrab without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}
