package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.behaviours.Behaviour;
import game.items.Rune;
import game.reset.ResetManager;
import game.reset.Resettable;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static game.actors.enemies.EnemyType.*;

public abstract class Enemy extends Actor implements Resettable {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    private ArrayList<Rune> runes = new ArrayList<>();
    private Actor spawner = null;

    public Enemy(String name, char displayChar, int hitPoints, EnemyType enemyType) {
        super(name, displayChar, hitPoints);
        this.maxHitPoints = hitPoints;
        this.addCapability(Status.ENEMY);
        this.addCapability(Status.SPAWNABLE);
        this.addCapability(enemyType);
        ResetManager.getInstance().registerResettable(this);
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

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (this.isConscious()) {
            if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                actions.add(new AttackAction(this, direction));
                for (Weapon weapon: otherActor.getWeaponInventory()) {
                    actions.add(new AttackAction(this, direction, weapon));
                }
            }
        }
        return actions;
    }

    public String reset(Actor actor, GameMap map) {
        if (this.hasCapability(Status.SPAWNABLE)) {
            map.removeActor(this);
            ResetManager.getInstance().removeResettable(this);
            return this + " has been despawned from game ";
        }
        return null;
    }
}
