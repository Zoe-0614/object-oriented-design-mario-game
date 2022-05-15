package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.*;
import game.enemies.Bowser;
import game.enemies.Koopa;
import game.fountains.HealthFountain;
import game.fountains.PowerFountain;
import game.grounds.*;
import game.items.PowerStar;
import game.items.SuperMushroom;

import java.util.Arrays;
import java.util.List;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Sprout());

		List<String> map = Arrays.asList(
				"..........................................##..........+.........................",
				"............+............+..................#...................................",
				"............................................#...................................",
				".............................................##......................+..........",
				"...............................................#................................",
				"................................................#...............................",
				".................+................................#.............................",
				".................................................##.............................",
				"................................................##..............................",
				".........+..............................+#____####.................+............",
				".......................................+#_____###++.............................",
				".......................................+#______###..............................",
				"........................................+#_____###..............................",
				"........................+........................##.............+...............",
				"...................................................#............................",
				"....................................................#...........................",
				"...................+.................................#..........................",
				"......................................................#.........................",
				".......................................................##.......................");

		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		FancyGroundFactory groundFactoryLavaZone = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
				new Sprout(), new Lava());

		List<String> map2 = Arrays.asList(
				"..........................................##.....................",
				"............+............+..................#....................",
				"..............LLLLLLLLLL....................#....................",
				"..............LLLLLLLLLL.....................##..................",
				"...............................................#.................",
				"................................................#................",
				".................+................................#..............",
				".................................................##..............",
				"................................................##...............",
				".........+..............................+#____####...............",
				".......................................+#_____###++..............",
				"........................................#______###...............");

		GameMap lavaZone = new GameMap(groundFactoryLavaZone, map2);
		world.addGameMap(lavaZone);

		for (int x : gameMap.getXRange()) {
			for (int y : gameMap.getYRange()) {
				Location groundLocation = gameMap.at(x, y);
				groundLocation.getGround().tick(groundLocation);
			}
		}

		for (int x : lavaZone.getXRange()) {
			for (int y : lavaZone.getYRange()) {
				Location groundLocation = lavaZone.at(x, y);
				groundLocation.getGround().tick(groundLocation);
			}
		}

		Actor mario = new Player("Mario", 'm', 100);
		world.addPlayer(mario, gameMap.at(42, 10));
		gameMap.at(43, 10).addItem(new PowerStar());
		gameMap.at(41, 10).addItem(new SuperMushroom());
		gameMap.at(42, 11).addActor(new Toad());

		gameMap.at(30, 10).setGround(new WarpPipe(lavaZone.at(0, 0), "Lava Zone"));
		gameMap.at(35,  14).setGround(new WarpPipe(lavaZone.at(0, 0), "Lava Zone"));
		gameMap.at(42,  8).setGround(new WarpPipe(lavaZone.at(0, 0), "Lava Zone"));
		lavaZone.at(0, 0).setGround(new WarpPipe(null, "Main Map"));
		lavaZone.at(2, 5).addActor(new PrincessPeach());
		lavaZone.at(3, 5).addActor(new Bowser(lavaZone.at(3, 5)));

		gameMap.at(43,9).setGround(new HealthFountain());
		gameMap.at(45,9).setGround(new PowerFountain());
		gameMap.at(30,8).setGround(new HealthFountain());
		gameMap.at(28,6).setGround(new PowerFountain());
		lavaZone.at(4,9).setGround(new HealthFountain());
		lavaZone.at(8,3).setGround(new PowerFountain());

		world.run();

	}
}
