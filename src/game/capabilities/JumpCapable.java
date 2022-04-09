package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public interface JumpCapable {
    default boolean jump(Actor actor, Location locationToJump, GameMap map) {
        int jumpChance = new Random().nextInt(100);
        if (jumpChance < getChance()) {
            map.moveActor(actor, locationToJump);
            return true;
        } else {
            actor.hurt(getDamage());
            return false;
        }
    }

    String getName();
    int getDamage();
    int getChance();
}
