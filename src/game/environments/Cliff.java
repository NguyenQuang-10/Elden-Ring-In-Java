package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DeathAction;
import game.actions.ResetAction;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.SkeletalBandit;
import game.reset.ResetManager;
import game.utils.Calculation;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class Cliff extends Ground {

    /**
     * Constructor.
     */
    public Cliff() {
        super('+');
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()) {
            Actor actor = location.getActor();
            if (actor.hasCapability(Status.PLAYER)) {
                actor.hurt(999999);
                new ResetAction().execute(actor, location.map());
            } else {
                new DeathAction(actor).execute(actor, location.map());
            }

        }
    }

}
