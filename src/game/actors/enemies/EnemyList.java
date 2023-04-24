package game.actors.enemies;

import game.behaviours.Behaviour;

import java.util.ArrayList;

public class EnemyList {

    private ArrayList<Enemy> enemies;
    private static EnemyList instance;
    private EnemyList() {
        this.enemies = new ArrayList<>();
    };

    public static EnemyList getInstance() {
        if (instance == null) {
            instance = new EnemyList();
        }
        return instance;
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public void addBehaviourToEnemies(int key, Behaviour behaviour) {
        for(Enemy enemy: this.enemies) {
            enemy.addBehaviour(key, behaviour);
        }
    }
}
