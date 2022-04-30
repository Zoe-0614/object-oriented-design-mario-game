package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

/**
 * JumpCapable is an interface where classes that can be jumped to can implement.
 *
 * @author Chua Shin Herh
 * @version 1.0
 */
public interface JumpCapable {
    /**
     * A default method for all Jump Capable classes to use which performs the actual jump action.
     * @param actor The actor performing the jump.
     * @param locationToJump The location to jump to.
     * @param map The map of the game.
     * @return a boolean indicating whether the jump has succeeded.
     */
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

    /**
     * Returns the name of the Jump Capable ground.
     * @return a String which is the name of the Jump Capable ground.
     */
    String getName();

    /**
     * Returns the damage dealt by the Jump Capable ground if the actor fails the jump.
     * @return an integer which is the damage dealt by the Jump Capable ground if the actor fails the jump.
     */
    int getDamage();

    /**
     * Returns the probability of a successful jump.
     * @return an integer which is the probability of a successful jump.
     */
    int getChance();
}
