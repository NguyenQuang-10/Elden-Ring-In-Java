package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.*;

import java.util.ArrayList;

/**
 * BEHOLD, DOG!
 * Lone Wolf enemy
 * Created by:
 * @author Adrian Kristanto
 * Modified by: AppliedSession03Gropu03
 *
 */
public class LoneWolf extends Enemy {

    /**
     * A public constructor
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102, EnemyType.FOURLEGANIMAL);
        this.addRune(55, 1470);
        this.addCapability(EnemyType.FOLLOWER);


        this.setBehaviour(0, new AttackBehaviour(false));

        // behaviour at key 1 is reserved for follow behaviour

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.setBehaviour(i+2, behaviours.get(i));
        }
    }

    /**
     * Returns the default attack capability of LoneWolf without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}
