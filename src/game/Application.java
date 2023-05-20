package game;

import java.util.*;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.actors.enemies.*;
import game.actors.traders.FingerReaderEnia;
import game.actors.Player;
import game.actors.traders.MerchantKale;
import game.environments.*;
import game.items.GoldenRune;
import game.utils.*;
import game.items.RemembranceOfTheGrafted;

import javax.security.auth.login.LoginException;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: AppliedSession03Group03
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());


		HashMap<String, GameMap> mapDict = Application.setUpMaps(world);
		GameMap limgrave = mapDict.get("Limgrave");

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		int middleX = limgrave.getXRange().max() / 2;
		int middleY = limgrave.getYRange().max() / 2;

		limgrave.at(middleX, middleY).addActor(new MerchantKale());
		limgrave.at(middleX, middleY+2).addActor(new FingerReaderEnia());
		ArchetypeManager archetypeManager = new ArchetypeManager(); // Added by Ryan.
		Player player = archetypeManager.createPlayer();

		player.addItemToInventory(new GoldenRune());
		player.addItemToInventory(new RemembranceOfTheGrafted());
//		player.addRuneBalance(30000000); # for testing

		// Added by Ryan.
		// HINT: what does it mean to prefer composition to inheritance?
		// Player player = new Player("Tarnished", '@', 300);
		world.addPlayer(player, limgrave.at(36, 10));
//		limgrave.addActor(new Dog(), limgrave.at(32,10));
//		limgrave.addActor(new GodrickSoldier(), limgrave.at(33,10));
//		limgrave.addActor(new HeavySkeletalSwordsman(), limgrave.at(32,9));
//		limgrave.addActor(new LoneWolf(), limgrave.at(33,9));
		player.setLastSiteOfLostGrace(limgrave.at(36, 10));

		world.run();
	}

	private static HashMap<String, GameMap> setUpMaps(World world) {
		FancyGroundFactory groundFactory = new FancyGroundFactory(new SiteOfLostGrace() ,new Dirt(),
				new Wall(), new Floor(), new Graveyard(), new PuddleOfWater(), new GustOfWind(), new Cliff()
				, new Cage(), new Barrack(), new SummonSign());


		GameMap roundtableHold = new GameMap(groundFactory, Maps.ROUNDTABLE_HOLD);
		GameMap limgrave = new GameMap(groundFactory, Maps.LIMGRAVE);
		GameMap stormveilCastle = new GameMap(groundFactory, Maps.STORMVEIL_CASTLE);
		GameMap bossRoom = new GameMap(groundFactory, Maps.BOSS_ROOM);

		limgrave.at(53,7).setGround(new GoldenFogDoor(roundtableHold.at(9, 10), "to Roundtable Hold"));
		limgrave.at(4, 17).setGround(new GoldenFogDoor(stormveilCastle.at(38, 23), "to Stormveil Castle"));
		scatterGoldenRunes(limgrave, 10);

		roundtableHold.at(9, 10).setGround(new GoldenFogDoor(limgrave.at(53,7), "to Limgrave"));


		stormveilCastle.at(37, 2).setGround(new GoldenFogDoor(bossRoom.at(12, 3), "to Boss Room"));
		stormveilCastle.at(38, 23).setGround(new GoldenFogDoor(limgrave.at(4,17), "to Limgrave"));
		scatterGoldenRunes(stormveilCastle, 7);

		world.addGameMap(limgrave);
		world.addGameMap(stormveilCastle);
		world.addGameMap(roundtableHold);
		world.addGameMap(bossRoom);

		roundtableHold.at(9, 5).addActor(new FingerReaderEnia());

		HashMap<String, GameMap> mapDict = new HashMap<String, GameMap>();
		mapDict.put("Limgrave", limgrave);
		mapDict.put("Stormveil Castle", stormveilCastle);
		mapDict.put("Roundtable Hold", roundtableHold);
		mapDict.put("Boss Room", bossRoom);

		return mapDict;

	}

	private static void scatterGoldenRunes(GameMap map, int goldenRuneCount) {
		int added = 0;
		int maxX = map.getXRange().max();
		int maxY = map.getYRange().max();
		while (added < goldenRuneCount ) {
			int randomX = RandomNumberGenerator.getRandomInt(0, maxX);
			int randomY = RandomNumberGenerator.getRandomInt(0, maxY);
			Location location = map.at(randomX, randomY);
			// if this location is not a wall
			if (!(location.getGround() != null && location.getGround().hasCapability(Status.WALL))) {
				location.addItem(new GoldenRune());
				added += 1;
			}
		}
	}
}
