package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.WeaponEffectAction;
import game.utils.WeaponEffect;

/**
 * Req 5
 *
 * A behaviour that executes WeaponEffect for 3 turns on enemies that were attacked
 * with Weapon that have WeaponEffect (ConcussionStaff and PoisonedAxe)
 */
public class WeaponEffectBehaviour implements Behaviour {

    /**
     * Number of turns more actor has to be fainted
     */
    private int faintTurns = 3;

    /**
     * Number of turns more actor has to be poisoned
     */
    private int poisonTurns = 3;

    /**
     * Returns WeaponEffectAction until the 3rd turn since the actor was attacked
     * with a WeaponEffect weapon. If more 3 turns have passed WeaponEffect is removed from the
     * actor and null returned
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return WeaponEffectAction
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // Deals with fainted actor
        if (actor.hasCapability(WeaponEffect.FAINTED) && this.faintTurns > 0) {
            // actor fainted for 3 turns
            this.faintTurns -= 1;
            return new WeaponEffectAction();
        } else if (actor.hasCapability(WeaponEffect.FAINTED) && this.faintTurns == 0) {
            // actor not fainted after 3 turns
            actor.removeCapability(WeaponEffect.FAINTED);
            this.faintTurns = 3;
        }

        // Deals with poisoned actor
        if (actor.hasCapability(WeaponEffect.POISONED) && this.poisonTurns > 0) {
            // actor poisoned for 3 turns
            this.poisonTurns -= 1;
            return new WeaponEffectAction();
        } else if (actor.hasCapability(WeaponEffect.POISONED) && this.poisonTurns == 0) {
            // actor not poisoned after 3 turns
            actor.removeCapability(WeaponEffect.POISONED);
            this.poisonTurns = 3;
        }
        return null;
    }
}
