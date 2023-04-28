package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.*;
import game.weapons.Scimitar;

import java.util.ArrayList;

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


        this.setBehaviour(0, new AttackBehaviour(true));

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.setBehaviour(i+2, behaviours.get(i));
        }
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
