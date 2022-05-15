package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Bottle;

/**
 * Special Action for giving the bottle to the player.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class GiveBottleAction extends Action {
    /**
     * Indicate the bottle to fill up the Magical Fountain's water
     */
    private Bottle bottle;
    /**
     * A constructor for the BuyAction class.
     */
    public GiveBottleAction() {
        this.bottle = Bottle.getInstance();
    }

    /**
     * Add bottle to player's inventory if bottle doesn't exist
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (!actor.getInventory().contains(bottle)) {
            actor.addItemToInventory(this.bottle);
            return menuDescription(actor);
        }
        return null;
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Mario gets bottle from Toad"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " gets bottle from Toad";
    }
}
