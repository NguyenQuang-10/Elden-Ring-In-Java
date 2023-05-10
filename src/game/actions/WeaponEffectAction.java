package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.WeaponEffect;

public class WeaponEffectAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(WeaponEffect.POISONED)) {
            actor.hurt(50);
            return actor + " has been poisoned for 50 damage";
        }
        return actor + " is still fainted";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
