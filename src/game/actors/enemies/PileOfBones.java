package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.Behaviour;
import game.behaviours.ReviveBehaviour;

import static game.actors.enemies.EnemyType.PILEOFBONES;

public class PileOfBones extends Enemy {

    private int turn;
    private Actor spawner;
    public PileOfBones(){
        super("Pile of Bones", 'X', 10, PILEOFBONES);
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.turn += 1;
        return null;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return super.allowableActions(otherActor, direction, map);
    }

    @Override
    public void hurt(int points) {
        this.hitPoints = 0;
    }
}
