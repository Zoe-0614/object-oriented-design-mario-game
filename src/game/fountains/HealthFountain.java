package game.fountains;

import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.items.HealthWater;

public class HealthFountain extends MagicalFountain {

    private HealthWater water;
    /***
     * Constructor.
     */
    public HealthFountain() {
        super("Health Fountain", 'H');
        this.water = new HealthWater();
    }


    public HealthWater getWater() {
        return water;
    }
}
