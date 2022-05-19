package game.enemies;

import edu.monash.fit2099.engine.positions.Location;
import game.Monologue;

import java.util.ArrayList;

/**
 * Class representing a Flying Koopa.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class FlyingKoopa extends Koopa {
    /**
     * List of monologue script
     */
    private ArrayList<String> talkList = new ArrayList();

    /**
     * Constructor.
     *
     * @param location the location of Koopa
     */
    public FlyingKoopa(Location location) {
        super("FlyingKoopa", 'F', 150, location);
        talkList.add("Pam pam pam!");
        Monologue.addActor(this);
        Monologue.addTalkList(this,talkList);
    }
}
