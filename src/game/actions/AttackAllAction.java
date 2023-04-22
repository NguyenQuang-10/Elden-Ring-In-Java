package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.Random;

public class AttackAllAction extends Action {

    private Weapon weapon;

    public AttackAllAction() {}
    public AttackAllAction(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " attacks surrounding \n";

        Location here = map.locationOf(actor);

        for(Exit exit: here.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && RandomNumberGenerator.getRandomInt(1, 100) <= 50) {
                Actor target = destination.getActor();
                if (target.isConscious())
                    result += (new AttackAction(target, exit.getName())).execute(actor, map) + "\n";
            }
        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
