package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Invader extends Actor {
    /**
     * Constructor.
     * @param hitPoints The hit points that the invader would have.
     * @param weapon    The initial weapon that would be in the invader's inventory.
     */
    public Invader(int hitPoints, WeaponItem weapon) {
        super("Invader",'ඞ', hitPoints);
        this.addWeaponToInventory(weapon);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
