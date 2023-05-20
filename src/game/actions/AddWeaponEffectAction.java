package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.WeaponEffect;

/**
 * Req 5
 *
 * Action to add WeaponEffect to target that gets attacked with a Weapon that have WeaponEffect
 * (ConcussionStaff and PoisonedAxe). Returned by (ConcussionStaff and PoisonedAxe) via getSkill()
 * @author AppliedSession03Group03
 */
public class AddWeaponEffectAction extends Action {

    /**
     * The Actor being attacked
     */
    private Actor target;

    /**
     * The weapon effect
     */
    private WeaponEffect weaponEffect;

    /**
     * The weapon producing WeaponEffect with special skill (ConcussionStaff and PoisonedAxe)
     */
    private WeaponItem weapon;

    /**
     * A public constructor
     * @param target The Actor being attacked
     * @param weaponEffect The weapon effect
     * @param weapon The weapon producing WeaponEffect with special skill (ConcussionStaff and PoisonedAxe)
     */
    public AddWeaponEffectAction(Actor target, WeaponEffect weaponEffect, WeaponItem weapon) {
        this.target = target;
        this.weaponEffect = weaponEffect;
        this.weapon = weapon;
    }

    /**
     * WeaponEffect is added as a capability to the target
     * This helps WeaponEffectBehaviour to ensure the special skills of the weapons
     * is executed for 3 turns
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        this.target.addCapability(this.weaponEffect);
        return target + " has been " + this.weaponEffect;
    }

    /**
     * Description for Menu UI
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses " + this.weapon + " to make " + this.target + " " + this.weaponEffect;
    }
}
