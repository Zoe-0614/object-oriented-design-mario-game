package game.fountains;

import game.items.HealingWater;
import java.util.ArrayList;

/**
 * A fountain that produces Healing Water.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class HealthFountain extends MagicalFountain {
    /***
     * Indicate the ArrayList that stores the Healing Water.
     */
    private ArrayList<HealingWater> waters = new ArrayList<>();
    /***
     * Constructor.
     */
    public HealthFountain() {
        super("Health Fountain", 'H');
        for (int i = 0; i < 10; i++) {
            this.waters.add(new HealingWater());
        }
    }

    /**
     * Get the water of the Magical Fountain
     * @return a water, eg. Healing Water
     */
    @Override
    public HealingWater getWater() {
        HealingWater water = waters.remove(waters.size()-1);
        return water;
    }

    /**
     * Indicate the remaining water left in the Health Fountain
     * @return an int, eg. 10
     */
    @Override
    public int getWaterLeft(){
        return waters.size();
    }
}
