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

import java.util.ArrayList;

public class GiantCrab extends Enemy {

    /**
     * A public constructor
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407, EnemyType.SEAANIMAL);
        this.addRune(318, 4961);

        int s = 0;
        ArrayList<Player> players = PlayersList.getInstance().getPlayers();
        while (s < players.size()) {
            this.addBehaviour(s, new FollowBehaviour(players.get(s)));
        }

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new AttackBehaviour(true));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.addBehaviour(i+s, behaviours.get(i));
        }
    }



    /**
     * Returns the default attack capability of GiantCrab without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}
