package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public interface TeleportCapable {
    /**
     * A default method for all Teleport Capable classes to use which performs the actual teleport action.
     * @param actor The actor performing the teleportation.
     * @param map The map of the game.
     */
    default void teleport(Actor actor, GameMap map) {
        Location destinationLocation = getDestinationLocation();
        if (destinationLocation.map().isAnActorAt(destinationLocation)) {
            destinationLocation.map().removeActor(destinationLocation.map().getActorAt(destinationLocation));
        }
        Location prev = map.locationOf(actor);
        map.moveActor(actor, destinationLocation);
        TeleportCapable destinationTeleporter = (TeleportCapable) map.locationOf(actor).getGround();
        destinationTeleporter.setDestinationLocation(prev);
    }

    /**
     * Returns the destination location of the warp pipe.
     * @return a Location instance which is the destination location of the warp pipe.
     */
    Location getDestinationLocation();

    /**
     * Sets the destination location of the warp pipe.
     * @param destinationLocation the destination location of the warp pipe
     */
    void setDestinationLocation(Location destinationLocation);
}
