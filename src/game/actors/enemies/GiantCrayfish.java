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

public class GiantCrayfish extends Enemy {

    /**
     * A public constructor
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803, EnemyType.SEAANIMAL);
        this.addRune(500, 2374);

        this.addBehaviour(0, new AttackBehaviour(true));

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
     * Returns the default attack capability of GiantCrayfish without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }
}
