package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Bottle;
import game.items.MagicalItem;
import java.util.Stack;

/**
 * Special Action for consuming the magical water from the bottle.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class ConsumeBottleAction extends Action{
    /**
     * The player's bottle
     */
    private Bottle bottle;
    /**
     * A stack that stores the waters
     */
    private Stack<MagicalItem> waters;
    /**
     * Constructor.
     *
     * @param bottle the fountain water in the bottle to be consumed
     */
    public ConsumeBottleAction(Bottle bottle) {
        this.bottle = bottle;
    }

    /**
     * Consume the water from the bottle
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        waters = bottle.getFill();
        if (waters.size() != 0) {
            MagicalItem water = waters.pop();
            water.consumedBy(actor, map);
        }

        return menuDescription(actor);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Mario consumes bottle[Healing Water, Healing Water, Power Water]"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes bottle" + bottle;
    }
}
