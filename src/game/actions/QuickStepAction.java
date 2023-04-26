package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.behaviours.WanderBehaviour;
import game.weapons.Uchigatana;

import java.util.ArrayList;

public class QuickStepAction extends Action {
    private WeaponItem weapon;
    private Actor target;
    private String direction;
    public QuickStepAction(WeaponItem weapon, Actor target, String direction){
        this.weapon = weapon;
        this.target = target;
        this.direction = direction;
    }

    /**
     * This method executes the unique skill to the GreatKnife, it deals the normal damage from the weapon to the enemy.
     * After which, the actor moves away from the enemy, evading their attack.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The string result of the attack.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " quicksteps " + target + " at " + direction + " with " + weapon + "\n";
        result += (new AttackAction(this.target, this.direction, this.weapon)).execute(actor, map);

        Action moveActor = (new WanderBehaviour()).getAction(actor, map);

        if (moveActor != null)
            result += moveActor.execute(actor, map);

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " quicksteps " + target + " at " + direction + " with " + weapon;
    }


}
