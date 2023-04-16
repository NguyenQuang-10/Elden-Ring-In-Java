package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class GiantDog extends Enemy {
    public GiantDog() {
        super("Giant Dog", 'G', 693);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "slams", 90);
    }
}
