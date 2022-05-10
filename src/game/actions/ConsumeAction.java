package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.MagicalItem;

/**
 * Special Action for consuming Magical Items.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public abstract class ConsumeAction extends Action {

    /**
     * The Magical Item that will be consumed
     */
    private final MagicalItem magicalItem;

    /**
     * Constructor.
     *
     * @param magicalItem the item to consume
     */
    public ConsumeAction(MagicalItem magicalItem) {
        this.magicalItem = magicalItem;
    }

    /**
     * Remove the item from the actor's inventory or remove the item from the location to consume.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (map.locationOf(actor).getItems().contains(magicalItem)){
            map.locationOf(actor).removeItem(magicalItem);
        } else if (actor.getInventory().contains(magicalItem)){
        actor.removeItemFromInventory(magicalItem);
    }
        magicalItem.consumedBy(actor, map);
        return menuDescription(actor);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player consumes Super Mushroom"
     */
    @Override
    public abstract String menuDescription(Actor actor);

}
