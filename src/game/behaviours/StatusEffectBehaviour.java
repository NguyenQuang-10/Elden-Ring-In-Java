package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Status;

public class StatusEffectBehaviour implements Behaviour {

    private int faintTurns = 3;
    private int poisonTurns = 3;

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.FAINTED) && this.faintTurns > 0) {
            this.faintTurns -= 1;
            return new DoNothingAction();
        } else if (actor.hasCapability(Status.FAINTED) && this.faintTurns == 0) {
            actor.removeCapability(Status.FAINTED);
            this.faintTurns = 3;
        }

        if (actor.hasCapability(Status.POISONED) && this.poisonTurns > 0) {
            this.poisonTurns -= 1;
            actor.hurt(50);
            return new DoNothingAction();
        } else if (actor.hasCapability(Status.POISONED) && this.poisonTurns == 0) {
            actor.removeCapability(Status.POISONED);
            this.poisonTurns = 3;
        }
        return null;
    }
}
