package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import static game.actors.enemies.EnemyType.PILEOFBONES;

public class PileOfBones extends Enemy{

    private int turn;
    private Enemy enemy;
    public PileOfBones(Enemy enemy){
        super("Pile of Bones", 'X', 10, PILEOFBONES);
        this.enemy = enemy;
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.turn += 1;
        return null;
    }
}
