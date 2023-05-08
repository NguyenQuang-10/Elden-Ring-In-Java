package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Dog;
import game.actors.enemies.GodrickSoldier;
import game.utils.RandomNumberGenerator;

public class Barrack extends Ground {
    public Barrack() {
        super('B');
    }

    @Override
    public void tick(Location location) {
        int rand = RandomNumberGenerator.getRandomInt(0, 100);
        int spawnRatePercent = 45;
        if (rand <= spawnRatePercent && !location.containsAnActor()) {
            location.addActor(new GodrickSoldier());
        }
    }
}
