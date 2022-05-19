package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FireFlower;

/**
 * Special Action for Consuming Fire Flower
 * @author Loh Zhun Guan
 * @version 1.0
 */

public class ConsumeFireFlowerAction extends ConsumeAction{
    /**
     * Indicate Fire Flower
     */
    private FireFlower fireFlower;
    /**
     * Constructor.
     *
     * @param fireFlower the item to consume
     */
    public ConsumeFireFlowerAction(FireFlower fireFlower) {
        super(fireFlower);
        this.fireFlower = fireFlower;
    }

    /**
     * Remove the fire flower from the actor's inventory or remove the item from the location to consume.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return super.execute(actor, map);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player consumes Super Mushroom"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + fireFlower;
    }
}
