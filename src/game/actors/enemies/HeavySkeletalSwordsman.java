package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SpawnAction;
import game.actors.Player;
import game.behaviours.*;
import game.items.Rune;
import game.weapons.Grossmesser;

import java.util.ArrayList;

public class HeavySkeletalSwordsman extends Enemy {

    /**
     * A public constructor
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153, EnemyType.SKELETON);
        this.addRune(35, 892);
        this.addWeaponToInventory(new Grossmesser());

        int s = 0;
        ArrayList<Player> players = PlayersList.getInstance().getPlayers();
        while (s < players.size()) {
            this.addBehaviour(s, new FollowBehaviour(players.get(s)));
            s++;
        }

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new SpawnBehaviour(new PileOfBones(this)));
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new AttackBehaviour(false));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.addBehaviour(i+s, behaviours.get(i));
        }
    }




    /**
     * Returns the default attack capability of HeavySkeletalSwordsman without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return super.allowableActions(otherActor, direction, map);
    }
}
