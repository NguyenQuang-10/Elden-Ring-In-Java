package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.WeaponEffectAction;
import game.utils.WeaponEffect;

public class WeaponEffectBehaviour implements Behaviour {

    private int faintTurns = 3;
    private int poisonTurns = 3;

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (actor.hasCapability(WeaponEffect.FAINTED) && this.faintTurns > 0) {
            this.faintTurns -= 1;
            return new WeaponEffectAction();
        } else if (actor.hasCapability(WeaponEffect.FAINTED) && this.faintTurns == 0) {
            actor.removeCapability(WeaponEffect.FAINTED);
            this.faintTurns = 3;
        }

        if (actor.hasCapability(WeaponEffect.POISONED) && this.poisonTurns > 0) {
            this.poisonTurns -= 1;
            return new WeaponEffectAction();
        } else if (actor.hasCapability(WeaponEffect.POISONED) && this.poisonTurns == 0) {
            actor.removeCapability(WeaponEffect.POISONED);
            this.poisonTurns = 3;
        }
        return null;
    }
}
