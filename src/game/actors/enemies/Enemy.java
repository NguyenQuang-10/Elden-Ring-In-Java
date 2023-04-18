package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.items.Rune;
import game.reset.Resettable;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;

import static game.actors.enemies.EnemyType.*;

public abstract class Enemy extends Actor implements Resettable {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public Enemy(String name, char displayChar, int hitPoints, EnemyType enemyType) {
        super(name, displayChar, hitPoints);
        this.maxHitPoints = hitPoints;
        this.addBehaviour(999, new WanderBehaviour());
        this.addCapability(Status.ENEMY);
        this.addCapability(enemyType);
    }

    public void addBehaviour(int key, Behaviour behaviour) {
        this.behaviours.put(key, behaviour);
    }

    public Map<Integer, Behaviour> getBehaviours() {
        return this.behaviours;
    }

    public void addRune(int min, int max) {
        this.addItemToInventory(new Rune(min, max));
    }

    public static boolean isSameEnemy(Actor actor1, Actor actor2) {
        if (actor1.hasCapability(SKELETON) && actor2.hasCapability(SKELETON)) {
            return true;
        } else if (actor1.hasCapability(FOURLEGANIMAL) && actor2.hasCapability(FOURLEGANIMAL)) {
            return true;
        } else if (actor1.hasCapability(SEAANIMAL) && actor2.hasCapability(SEAANIMAL)) {
            return true;
        } else {
            return false;
        }
    }
    public void reset() {}
}
