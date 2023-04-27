package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actors.Player;
import game.behaviours.*;
import game.utils.Calculation;
import game.utils.Status;
import game.weapons.Scimitar;

import java.util.ArrayList;

public class SkeletalBandit extends Enemy {

    /**
     * A public constructor
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184, EnemyType.SKELETON);
        this.addWeaponToInventory(new Scimitar());
        this.addRune(35, 892);
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
     * Returns the default attack capability of SkeletalBandit without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return super.allowableActions(otherActor, direction, map);
    }
}
