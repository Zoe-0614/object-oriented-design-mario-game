package game.enemies;

import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.JumpCapable;

public class FlyingKoopa extends Koopa {
    /**
     * Constructor.
     *
     * @param location the location of Koopa
     */
    public FlyingKoopa(Location location) {
        super("FlyingKoopa", 'F', 150, location);
    }
}
