package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Dog;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.SkeletalBandit;
import game.utils.Calculation;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents cage ground
 * @author AppliedSession03Group03
 */
public class Cage extends Ground {

    /**
     * A public constructor
     */
    public Cage() {
        super('<');
    }

    /**
     * At every turn Cage spawns a Dog enemy with 37% probability
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        int rand = RandomNumberGenerator.getRandomInt(0, 100);
        int spawnRatePercent = 37;
        if (rand <= spawnRatePercent && !location.containsAnActor()) {
            location.addActor(new Dog());
        }
    }

}
