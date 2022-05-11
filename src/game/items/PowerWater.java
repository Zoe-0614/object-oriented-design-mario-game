package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class PowerWater extends MagicalItem{
    /***
     * Constructor.
     */
    public PowerWater() {
        super("Power Water", 'P', false);
    }

    @Override
    public void consumedBy(Actor actor, GameMap map) {

    }
}
