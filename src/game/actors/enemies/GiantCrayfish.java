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

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new AttackBehaviour(true));

        for (Player player: PlayersList.getInstance().getPlayers()) {
            behaviours.add(new FollowBehaviour(player));
        }

        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        this.addBehaviours(behaviours);
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
