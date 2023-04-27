package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actors.Player;
import game.behaviours.*;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends Enemy {

    /**
     * A public constructor
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102, EnemyType.FOURLEGANIMAL);
        this.addRune(55, 1470);

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new AttackBehaviour(false));

        for (Player player: PlayersList.getInstance().getPlayers()) {
            behaviours.add(new FollowBehaviour(player));
        }

        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        this.addBehaviours(behaviours);
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
