package game;

import java.util.*;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.actors.MerchantKale;
import game.environments.*;
import game.items.GoldenRune;
import game.utils.ArchetypeManager;
import game.utils.FancyMessage;
import game.utils.Maps;
import game.weapons.RemembranceOfTheGrafted;

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
		ArchetypeManager archetypeManager = new ArchetypeManager(); // Added by Ryan.
		Player player = archetypeManager.createPlayer();
		player.addItemToInventory(new GoldenRune());
		player.addWeaponToInventory(new RemembranceOfTheGrafted());

		// Added by Ryan.
		// HINT: what does it mean to prefer composition to inheritance?
		// Player player = new Player("Tarnished", '@', 300);
		world.addPlayer(player, limgrave.at(36, 10));
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
		limgrave.at(4, 17).setGround(new GoldenFogDoor(stormveilCastle.at(38, 23), "to StormveilCastle"));

		roundtableHold.at(9, 10).setGround(new GoldenFogDoor(limgrave.at(53,7), "to Limgrave"));

		stormveilCastle.at(37, 2).setGround(new GoldenFogDoor(bossRoom.at(12, 3), "to Boss Room"));
		stormveilCastle.at(38, 23).setGround(new GoldenFogDoor(limgrave.at(4,17), "to Limgrave"));

		world.addGameMap(limgrave);
		world.addGameMap(stormveilCastle);
		world.addGameMap(roundtableHold);
		world.addGameMap(bossRoom);

		HashMap<String, GameMap> mapDict = new HashMap<String, GameMap>();
		mapDict.put("Limgrave", limgrave);
		mapDict.put("Stormveil Castle", stormveilCastle);
		mapDict.put("Roundtable Hold", roundtableHold);
		mapDict.put("Boss Room", bossRoom);

		return mapDict;

	}
}
