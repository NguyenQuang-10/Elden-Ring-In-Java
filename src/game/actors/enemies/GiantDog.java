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
 * Giant Dog, inhabitant of the Lands Between,
 * represented by G (uppercase G), that has 693 hit points and slams other creatures (single target attack),
 * including the player, with their head, dealing 314 damage with 90% accuracy.
 * @author AppliedSession03Group03
 */
public class GiantDog extends Enemy {

    /**
     * A public constructor
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693, EnemyType.FOURLEGANIMAL, true);
        this.addRune(313, 1808);
        this.addCapability(Status.FOLLOWER);

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
