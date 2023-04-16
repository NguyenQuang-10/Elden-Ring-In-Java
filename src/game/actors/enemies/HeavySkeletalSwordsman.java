package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Rune;

public class HeavySkeletalSwordsman extends Enemy {

    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.addRune(35, 892);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }
}
