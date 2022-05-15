package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.MagicalItem;

/**
 * Special Action for consuming the magical water directly from the fountain.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class ConsumeWaterAction extends Action {
    /**
     * The Magical Item that will be consumed
     */
    private final MagicalItem magicalItem;

    /**
     * Constructor.
     *
     * @param magicalItem the item to consume
     */
    public ConsumeWaterAction(MagicalItem magicalItem) {
        this.magicalItem = magicalItem;
    }

    /**
     * Consume the water directly from the Magical Fountain
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI, e.g. Goomba consumes Healing Water
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        magicalItem.consumedBy(actor, map);
        return actor + " consumes " + magicalItem.toString();
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. null in this case
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
