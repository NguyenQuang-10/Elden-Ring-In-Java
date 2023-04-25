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

        this.addBehaviour(0, new AttackBehaviour(false));

        int s = 0;
        ArrayList<Player> players = PlayersList.getInstance().getPlayers();
        while (s < players.size()) {
            this.addBehaviour(s+1, new FollowBehaviour(players.get(s)));
            s++;
        }
        s++;

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.addBehaviour(i+s, behaviours.get(i));
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
