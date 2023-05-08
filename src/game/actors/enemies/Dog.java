package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.DespawnBehaviour;
import game.behaviours.WanderBehaviour;
import game.utils.Status;

import java.util.ArrayList;

public class Dog extends Enemy {
    /**
     * A public constructor
     */
    public Dog() {
        super("Dog", 'a', 104, EnemyType.STORMVEIL);
        this.addRune(52, 1390);
        this.addCapability(Status.FOLLOWER);


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
     * Returns the default attack capability of Dog without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "hits", 93);
    }
}
