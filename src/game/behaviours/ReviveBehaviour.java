package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ReviveAction;
import game.actors.enemies.Enemy;

public class ReviveBehaviour implements Behaviour{

    private int turn;
    private Enemy reviver;

    public ReviveBehaviour(int turn, Enemy reviver){
        this.turn = turn;
        this.reviver = reviver;
    };

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (this.turn % 3 == 0) {
            return new ReviveAction(this.reviver);
        }
        return null;
    }
}
