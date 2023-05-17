package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Dog;
import game.actors.enemies.GodrickSoldier;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents Barrack ground
 * @author AppliedSession03Group03
 */
public class Barrack extends Ground {

    /**
     * A public constructor
     */
    public Barrack() {
        super('B');
    }

    /**
     * At every turn Cage spawns a GodrickSoldier enemy with 45% probability
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        int rand = RandomNumberGenerator.getRandomInt(0, 100);
        int spawnRatePercent = 45;
        if (rand <= spawnRatePercent && !location.containsAnActor()) {
            location.addActor(new GodrickSoldier());
        }
    }
}
