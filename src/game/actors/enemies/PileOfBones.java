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

import java.util.ArrayList;

import static game.actors.enemies.EnemyType.PILEOFBONES;

/**
 * Pile Of Bones
 * Heavy Skeletal Swordsman & Skeletal Bandit can turn to Pile Of Bones if killed
 * Heavy Skeletal Swordsman & Skeletal Bandit is respawned if Pile Of Bones not hit in 3 turns
 * AppliedSession03Group03
 */
public class PileOfBones extends Enemy implements Reviver {

    /**
     * The number of turns
     */
    private int turn;

    /**
     * The actor that spawned Pile of Bones
     */
    private Actor spawner;

    /**
     * A public constructor
     * @param spawner the Actor that spawned Pile of Bones
     */
    public PileOfBones(Actor spawner){
        super("Pile of Bones", 'X', 10, PILEOFBONES, false);
        this.addCapability(EnemyType.SKELETON);
        this.spawner = spawner;
        this.clearBehaviour();

        this.setBehaviour(0,new ReviveBehaviour(this));
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
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

    /**
     * Kills the PileOfBones no matter how much the damage from other Actor
     * @param points number of hitpoints to deduct.
     */
    @Override
    public void hurt(int points) {
        this.hitPoints = 0;
    }

    /**
     * Getter for spawner
     * @return the Actor that spawned Pile of Bones
     */
    @Override
    public Actor getSpawner() {
        return this.spawner;
    }

    /**
     * Checks if spawner needs to be revived
     * @return true if Pile of Bones not killed in 3 turns else false
     */
    @Override
    public boolean toRevive() {
        return this.turn % 3 == 0;
    }
}
