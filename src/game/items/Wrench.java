package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enums.Status;

/**
 * Class representing a Wrench
 * A weapon specifically used to destroy Koopa's shell
 */
public class Wrench extends WeaponItem {

    /**
     * Constructor
     */
    public Wrench() {
        super("wrench", 'w', 50, "destroys", 80);
        this.addCapability(Status.WRENCH);
    }

}
