package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.actors.MerchantKale;
import game.actors.archetypes.Archetypes;
import game.actors.enemies.LoneWolf;
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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new SiteOfLostGrace() ,new Dirt(),
				new Wall(), new Floor(), new Graveyard(), new PuddleOfWater(), new GustOfWind(), new Cliff()
				, new Cage(), new Barrack(), new SummonSign());

		List<String> map = Arrays.asList(
				"...........................................................................",
				"....n....&............#####....######.................................n....",
				"......................#..___....____#.............................n........",
				"........n.........................__#..........................&...........",
				".....n................._____........#......................................",
				"......................#............_#...........................&..........",
				"......................#...........###......................................",
				".......&...................................................................",
				".....................................=.....................................",
				"..................................###___###.......................~........",
				".....~............................__U_____#................................",
				"..........................+.......#________................................",
				".....~............................#_______#.......................~........",
				"..................................###___###................................",
				"....................................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
				"..####__###..................................................._.....__.#...",
				"..............................................................###..__###...",
				"...........................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
		GameMap roundtableHold = new GameMap(groundFactory, Maps.ROUNDTABLE_HOLD);
		world.addGameMap(gameMap);
		world.addGameMap(roundtableHold);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		int middleX = gameMap.getXRange().max() / 2;
		int middleY = gameMap.getYRange().max() / 2;

		gameMap.at(middleX, middleY).addActor(new MerchantKale());
		ArchetypeManager archetypeManager = new ArchetypeManager(); // Added by Ryan.
		Player player = archetypeManager.createPlayer();

		player.addItemToInventory(new GoldenRune());
		player.addWeaponToInventory(new RemembranceOfTheGrafted());

		// Added by Ryan.
		// HINT: what does it mean to prefer composition to inheritance?
		// Player player = new Player("Tarnished", '@', 300);
		world.addPlayer(player, gameMap.at(36, 10));
		player.setLastSiteOfLostGrace(gameMap.at(36, 10));

		gameMap.at(30,9).setGround(new GoldenFogDoor(roundtableHold.at(10, 6), "to Roundtable Hold"));

		world.run();
	}
	// start assignment 3
}
