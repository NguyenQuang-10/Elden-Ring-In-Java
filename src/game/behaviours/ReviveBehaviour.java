package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ReviveAction;
import game.actors.enemies.Enemy;
import game.actors.enemies.Reviver;

public class ReviveBehaviour implements Behaviour{

    private Reviver reviver;

    public ReviveBehaviour(Reviver reviver){
        this.reviver = reviver;
    };

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (this.reviver.toRevive()) {
            return new ReviveAction(this.reviver);
        }
        return null;
    }
}
