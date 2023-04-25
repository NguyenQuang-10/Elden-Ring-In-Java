package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.*;
import game.utils.Status;

public class GiantDog extends Enemy {

    /**
     * A public constructor
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693, EnemyType.FOURLEGANIMAL);
        this.addRune(313, 1808);
        this.addBehaviour(2, new DespawnBehaviour(10));
        this.addBehaviour(3, new AttackBehaviour(true));
        this.addBehaviour(99, new WanderBehaviour());
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
