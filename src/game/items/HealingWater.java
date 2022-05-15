package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Drinking this water will increase the drinker's hit points/healing by 50 hit points.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class HealingWater extends MagicalItem{
    /***
     * Constructor.
     */
    public HealingWater() {
        super("Healing Water", 'H', false);
    }

    /**
     * A method to execute the features after an Actor consumed Healing water
     *
     * @param actor The Actor who consumed the Healing Water
     * @param map   the map that contains this location
     */
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        actor.heal(50);
    }
}
