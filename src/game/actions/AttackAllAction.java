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
import game.utils.Status;

import java.util.Random;

public class AttackAllAction extends Action {

    private Weapon weapon;
    private Random rand = new Random();

    public AttackAllAction() {}
    public AttackAllAction(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";

        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        Location here = map.locationOf(actor);

        for(Exit exit: here.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                Actor target = destination.getActor();

                if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                    result += actor + " misses " + target + ".\n";
                } else {
                    int damage = weapon.damage();
                    result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.\n";
                    target.hurt(damage);
                    if (!target.isConscious()) {
                        result += new DeathAction(actor).execute(target, map);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
