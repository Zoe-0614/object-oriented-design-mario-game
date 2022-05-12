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
     */
    public PowerFountain() {
        super("Power Fountain", 'P');
        this.water = new PowerWater();
    }

    @Override
    public PowerWater getWater() {
        return water;
    }

}
