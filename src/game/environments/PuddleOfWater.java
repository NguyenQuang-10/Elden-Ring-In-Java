package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.GiantCrab;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents bare dirt.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class PuddleOfWater extends Ground {

	public PuddleOfWater() {
		super('&');
	}

	@Override
	public void tick(Location location) {
		int rand = RandomNumberGenerator.getRandomInt(0, 100);
		int spawnRatePercent = 2;
		if (rand < spawnRatePercent) {
			location.addActor(new GiantCrab());
		}
	}
}
