package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.enums.Status;

/**
 * Class representing the Super Mushroom.
 */

public class SuperMushroom extends MagicalItem {
    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', false);
        addAction(new ConsumeAction(this));
    }

    /**
     * The features after an Actor consumed Super Mushroom
     *
     * @param actor The Actor who consumed Super Mushroom
     * @param map   the map that contains this location
     */
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        actor.addCapability(Status.TALL);
        actor.increaseMaxHp(50);
    }


}
