package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enums.Status;

public class Wrench extends WeaponItem {

    public Wrench() {
        super("wrench", 'w', 50, "destroys", 80);
        this.addCapability(Status.WRENCH);
    }

}
