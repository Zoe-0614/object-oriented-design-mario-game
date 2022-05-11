package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public interface TeleportCapable {
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

    Location getDestinationLocation();

    void setDestinationLocation(Location destinationLocation);
}
