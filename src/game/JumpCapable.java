package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public interface JumpCapable {
    boolean jump(Actor actor, Location locationToJump, GameMap map);
    String getName();
    int getDamage();
}
