package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.behaviours.*;
import game.reset.ResetManager;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Invader extends Enemy {

    /**
     * A public constructor
     *
     * @param hitPoints   the Enemy's starting hit points
     * @param weapon      the invader's weapon

     */
    public Invader(int hitPoints, WeaponItem weapon) {
        super("Invader", 'ඞ', hitPoints, EnemyType.INVADER, false);
        this.addWeaponToInventory(weapon);
        this.addRune(1358, 5578);
        this.addCapability(Status.FOLLOWER);

        // Add weapon effect behaviour.

        this.setBehaviour(0, new AttackBehaviour(false, Status.INVADER));

        // Behaviour at key 1 is reserved for follow behaviour.

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.setBehaviour(i+2, behaviours.get(i));
        }
    }

    @Override
    public String reset(Actor actor, GameMap map) {
        if (!actor.isConscious()) {
            map.removeActor(this);
            ResetManager.getInstance().removeResettable(this);
            return this + " has been despawned from game ";
        }
        return null;
    }
}


