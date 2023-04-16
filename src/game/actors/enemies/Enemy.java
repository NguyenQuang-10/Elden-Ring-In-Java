package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.items.Rune;
import game.reset.Resettable;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemy extends Actor implements Resettable {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addBehaviour(999, new WanderBehaviour());
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

    public void reset() {}
}
