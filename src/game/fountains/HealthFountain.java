package game.fountains;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class HealthFountain extends MagicalFountain {
    private String water;
    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     */
    public HealthFountain(String name, char displayChar) {
        super(name, displayChar);
        this.water = "Healing water";
    }

    @Override
    public void consumedBy(Actor actor, GameMap map) {

    }


    public String getWater() {
        return this.water;
    }
}
