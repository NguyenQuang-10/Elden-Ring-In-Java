package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ReviveAction;
import game.actions.SpawnAction;
import game.behaviours.Behaviour;
import game.behaviours.ReviveBehaviour;

import static game.actors.enemies.EnemyType.PILEOFBONES;

public class PileOfBones extends Enemy implements Reviver {

    private int turn;
    private Actor spawner;
    public PileOfBones(Actor spawner){
        super("Pile of Bones", 'X', 10, PILEOFBONES);
        this.spawner = spawner;
        this.addBehaviour(1, new ReviveBehaviour(this));
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.turn += 1;
        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return super.allowableActions(otherActor, direction, map);
    }

    @Override
    public void hurt(int points) {
        this.hitPoints = 0;
    }

    @Override
    public Actor getSpawner() {
        return this.spawner;
    }

    @Override
    public boolean toRevive() {
        return this.turn % 3 == 0;
    }
}
