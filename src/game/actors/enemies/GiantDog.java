package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Player;
import game.behaviours.*;
import game.utils.Status;

import java.util.ArrayList;

public class GiantDog extends Enemy {

    /**
     * A public constructor
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693, EnemyType.FOURLEGANIMAL);
        this.addRune(313, 1808);
        this.addCapability(EnemyType.FOLLOWER);


        this.addBehaviour(0, new AttackBehaviour(true));

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.addBehaviour(i+2, behaviours.get(i));
        }
    }




    /**
     * Returns the default attack capability of GiantDog without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "slams", 90);
    }
}
