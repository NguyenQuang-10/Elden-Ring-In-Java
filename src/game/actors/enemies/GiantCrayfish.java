package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class GiantCrayfish extends Enemy {
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }
}
