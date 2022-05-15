package game.enemies;


import edu.monash.fit2099.engine.positions.Location;
/**
 * Class representing a walking(normal) Koopa.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class WalkingKoopa extends Koopa{
    /**
     * Constructor.
     *
     * @param location the location of Koopa
     */
    public WalkingKoopa(Location location) {
        super("Koopa", 'K', 100, location);
    }
}
