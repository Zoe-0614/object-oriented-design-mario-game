package game.enemies;

import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.FlyCapable;

public class FlyingKoopa extends Koopa implements FlyCapable {
    /**
     * Constructor.
     *
     * @param location the location of Koopa
     */
    public FlyingKoopa(Location location) {
        super(location);
    }
}
