package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.DespawnBehaviour;
import game.behaviours.WanderBehaviour;
import game.utils.Calculation;
import game.utils.Status;
import game.weapons.Scimitar;

public class SkeletalBandit extends Enemy {
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184, EnemyType.SKELETON);
        this.addWeaponToInventory(new Scimitar());
        this.addRune(35, 892);
        this.addBehaviour(97, new AttackBehaviour());
        this.addBehaviour(99, new WanderBehaviour());
        this.addBehaviour(100, new DespawnBehaviour(10));
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList allowedAction = super.allowableActions(otherActor, direction, map);
        if (Calculation.distance(map.locationOf(otherActor), map.locationOf(this)) <= 1) {
            Action attackThisActor = new AttackAction(this, direction, otherActor.getWeaponInventory().get(0)); // TODO: implementing player choosing weapon
            allowedAction.add(attackThisActor);
        }
        return allowedAction;

    }
}
