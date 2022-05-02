package game.capabilities;

import edu.monash.fit2099.engine.positions.Location;

/**
 * SpawnCapable is an interface where classes that can spawn things can implement
 */
public interface SpawnCapable {
    /**
     * Method that spawns things at their current location
     * @param location the location to spawn
     */
    void drop(Location location);
}
