package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.LoneWolf;
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
		if (rand < spawnRatePercent && !location.containsAnActor()) {
			location.addActor(new LoneWolf());
		}
	}
}
