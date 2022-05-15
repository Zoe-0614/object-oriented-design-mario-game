package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class HealingWater extends MagicalItem{
    /***
     * Constructor.
     */
    public HealingWater() {
        super("Healing Water", 'H', false);
    }

    @Override
    public void consumedBy(Actor actor, GameMap map) {
        actor.heal(50);
    }
}
