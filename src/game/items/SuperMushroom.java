package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;

public class SuperMushroom extends Item implements MagicalItem {
    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', true);
    }

    @Override
    public void consumedBy(Actor actor, GameMap map) {
        actor.addCapability(Status.TALL);
        actor.increaseMaxHp(50);
    }


}
