package game.actors;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.behaviours.*;
import game.reset.ResetManager;
import game.utils.Status;
import java.util.ArrayList;


/**
 * This class describes the characteristics and behaviours of Invader.
 * @author AppliedSession03Group03
 * @see Enemy
 */
public class Invader extends Enemy {

    /**
     * A public constructor.
     * @param hitPoints   The Enemy's starting hit points.
     * @param weapon      The invader's weapon.
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

    /**
     * Reset Ally to remove from the game.
     * @param actor The Actor that is being reset.
     * @param map The current GameMap.
     * @return A message saying the Invader have been despawned.
     */
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


