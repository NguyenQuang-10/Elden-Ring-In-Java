package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.*;
import game.utils.Status;
import game.weapons.Scimitar;

import java.util.ArrayList;

import static game.actors.enemies.EnemyType.FOLLOWER;

/**
 * Skeletal Bandit,  hostile creature,
 * represented by b (lowercase B), that has 184 hit points and carries around a weapon called Scimitar.
 * @author AppliedSession03Gropu03
 */
public class SkeletalBandit extends Enemy {

    /**
     * A public constructor
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184, EnemyType.SKELETON);
        this.addWeaponToInventory(new Scimitar());
        this.addRune(35, 892);
        this.addCapability(EnemyType.FOLLOWER);

        this.setBehaviour(1, new SpawnBehaviour(new PileOfBones(this)));
        this.setBehaviour(1, new AttackBehaviour(true));

        // behaviour at key 2 is reserved for follow behaviour

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.setBehaviour(i+2, behaviours.get(i));
        }
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(FOLLOWER)) {
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
     * Returns the default attack capability of SkeletalBandit without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return super.allowableActions(otherActor, direction, map);
    }
}
