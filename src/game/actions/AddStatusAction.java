package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class AddStatusAction extends Action {

    private Actor target;
    private Status status;
    private WeaponItem weapon;

    public AddStatusAction(Actor target, Status status, WeaponItem weapon) {
        this.target = target;
        this.status = status;
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        this.target.addCapability(this.status);
        return target + " has been " + this.status;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses " + this.weapon + " to " + this.status + " " + this.target;
    }
}
