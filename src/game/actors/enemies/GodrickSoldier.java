package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.DespawnBehaviour;
import game.behaviours.WanderBehaviour;
import game.utils.Status;
import game.weapons.HeavyCrossbow;

import java.util.ArrayList;

public class GodrickSoldier extends Enemy {
    /**
     * A public constructor
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198, EnemyType.STORMVEIL);
        this.addRune(38, 70);
        this.addCapability(Status.FOLLOWER);
        this.addWeaponToInventory(new HeavyCrossbow());


        this.setBehaviour(0, new AttackBehaviour(false));

        // behaviour at key 1 is reserved for follow behaviour

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.setBehaviour(i+2, behaviours.get(i));
        }
    }

}
