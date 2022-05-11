package game.fountains;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Player;
import game.items.HealthWater;
import game.items.PowerWater;

public class PowerFountain extends MagicalFountain {
    private PowerWater water;
    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     */
    public PowerFountain(String name, char displayChar) {
        super("Power Fountain", 'P');
        this.water = new PowerWater();
    }

    public PowerWater getWater() {
        return water;
    }

}
