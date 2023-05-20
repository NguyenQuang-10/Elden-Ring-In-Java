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
 * BEHOLD, DOG!
 * Lone Wolf enemy
 * Created by:
 * @author Adrian Kristanto
 * Modified by: AppliedSession03Group03
 *
 */
public class LoneWolf extends Enemy {

    /**
     * A public constructor
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102, EnemyType.FOURLEGANIMAL, false);
        this.addRune(55, 1470);
        this.addCapability(Status.FOLLOWER);

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
