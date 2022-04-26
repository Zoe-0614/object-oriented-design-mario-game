package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.enemies.Koopa;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.Sprout;
import game.grounds.Wall;
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

			Actor mario = new Player("Mario", 'm', 100);
			world.addPlayer(mario, gameMap.at(42, 10));
			gameMap.at(43, 8).addActor(new Koopa(gameMap.at(43, 8)));

			//add enemies randomly
			if(Math.random() <= 0.1){
				int x = (int)Math.random() * 100;
				int y = (int)Math.random() * 100;
				world.addPlayer(new Koopa(gameMap.at(x,y)), gameMap.at(x,y));
			}
			gameMap.at(42, 11).addActor(new Toad());

		if(Math.random() <= 0.8){
			gameMap.at((int)Math.random() * 100, (int)Math.random() * 100).addItem(new PowerStar());
			gameMap.at((int)Math.random() * 100, (int)Math.random() * 100).addItem(new SuperMushroom());
		}


			world.run();

	}
}
