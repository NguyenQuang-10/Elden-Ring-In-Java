package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.*;

import java.util.ArrayList;

/**
 * Giant Crayfish, hostile creature, represented by R (uppercase R),
 * that has 4803 hit points and slams other creatures (single target attack),
 * including the player, with their giant pincer, dealing 527 damage with 100% accuracy
 * @author AppliedSession03Gropu03
 */
public class GiantCrayfish extends Enemy {

    /**
     * A public constructor
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803, EnemyType.SEAANIMAL);
        this.addRune(500, 2374);
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
     * Returns the default attack capability of GiantCrayfish without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }
}
