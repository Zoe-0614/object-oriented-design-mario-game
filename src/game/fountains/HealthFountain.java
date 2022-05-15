package game.fountains;

import game.items.HealthWater;

import java.util.ArrayList;

public class HealthFountain extends MagicalFountain {

    private ArrayList<HealthWater> waters = new ArrayList<>();
    /***
     * Constructor.
     */
    public HealthFountain() {
        super("Health Fountain", 'H');
        for (int i = 0; i < 10; i++) {
            this.waters.add(new HealthWater());
        }
    }

//    @Override
//    /**
//     * Allowable actions of the MagicalFountain
//     * @param actor the Actor acting
//     * @param location the current Location
//     * @param direction the direction of the Ground from the Actor
//     * @return list of actions
//     */
//    public ActionList allowableActions(Actor actor, Location location, String direction) {
//        return super.allowableActions(actor,location,direction);
//    }

    @Override
    public HealthWater getWater() {
        HealthWater water = waters.remove(waters.size()-1);
        return water;
    }

    @Override
    public int getWaterLeft(){
        return waters.size();
    }
}
