package game.fountains;


import game.items.PowerWater;
import java.util.ArrayList;

/**
 * A fountain that produces Power Water.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class PowerFountain extends MagicalFountain {
    /***
     * Indicate the ArrayList that stores the Power Water.
     */
    private ArrayList<PowerWater> waters = new ArrayList<>();
    /***
     * Constructor.
     */
    public PowerFountain() {
        super("Power Fountain", 'A');
        for (int i = 0; i < 10; i++) {
            this.waters.add(new PowerWater());
        }
    }

    /**
     * Get the water of the Magical Fountain
     * @return a water, eg. Power Water
     */
    @Override
    public PowerWater getWater() {
        PowerWater water = waters.remove(waters.size()-1);
        return water;
    }

    /**
     * Indicate the remaining water left in the Power Fountain
     * @return an int, eg. 10
     */
    @Override
    public int getWaterLeft(){
        return waters.size();
    }

}
