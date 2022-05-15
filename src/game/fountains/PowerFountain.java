package game.fountains;



import game.items.PowerWater;

import java.util.ArrayList;

public class PowerFountain extends MagicalFountain {
    private ArrayList<PowerWater> waters = new ArrayList<>();
    /***
     * Constructor.
     */
    public PowerFountain() {
        super("Power Fountain", 'P');
        for (int i = 0; i < 10; i++) {
            this.waters.add(new PowerWater());
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
    public PowerWater getWater() {
        PowerWater water = waters.remove(waters.size()-1);
        return water;
    }

    @Override
    public int getWaterLeft(){
        return waters.size();
    }

}
