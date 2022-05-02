package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.*;
import game.enemies.Koopa;
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

			for (int x : gameMap.getXRange()) {
				for (int y : gameMap.getYRange()) {
					Location groundLocation = gameMap.at(x, y);
					groundLocation.getGround().tick(groundLocation);
				}
			}

			Actor mario = new Player("Mario", 'm', 100);
			world.addPlayer(mario, gameMap.at(42, 10));
			gameMap.at(43, 10).addItem(new PowerStar());
			gameMap.at(41, 10).addItem(new SuperMushroom());
			gameMap.at(42, 11).addActor(new Toad());

			world.run();

	}
}
