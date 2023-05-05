package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Dog;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.SkeletalBandit;
import game.utils.Calculation;
import game.utils.RandomNumberGenerator;

public class Cage extends Ground {
    public Cage() {
        super('<');
    }

    @Override
    public void tick(Location location) {
        int rand = RandomNumberGenerator.getRandomInt(0, 100);
        int spawnRatePercent = 37;
        if (rand <= spawnRatePercent && !location.containsAnActor()) {
            location.addActor(new Dog());
        }
    }

}
