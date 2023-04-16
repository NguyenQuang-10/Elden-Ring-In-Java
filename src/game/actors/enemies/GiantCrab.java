package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.WanderBehaviour;

public class GiantCrab extends Enemy {
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
        this.addRune(318, 4961);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}
