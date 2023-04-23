package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.GiantDog;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.LoneWolf;
import game.actors.enemies.SkeletalBandit;
import game.utils.Calculation;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents bare dirt.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class GustOfWind extends Ground {

	public GustOfWind() {
		super('~');
	}

	@Override
	public void tick(Location location) {
		int rand = RandomNumberGenerator.getRandomInt(0, 100);
		int spawnRatePercent = 33;
		if (rand < spawnRatePercent && !location.containsAnActor() && Calculation.isLocationWest(location)) {
			location.addActor(new LoneWolf());
		} else if (Calculation.isLocationEast(location)){
			location.addActor(new GiantDog());
		}
	}
}
