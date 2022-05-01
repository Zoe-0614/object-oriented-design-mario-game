package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.PowerStar;
/**
 * Special Action for consuming PowerStar.
 */
public class ConsumePowerStarAction extends Action {
    /***
     * Indicate the Power Star
     */
    private PowerStar powerStar;

    /**
     * Constructor.
     *
     * @param powerStar the item to consume
     */
    public ConsumePowerStarAction(PowerStar powerStar) {
        this.powerStar = powerStar;
    }

    /**
     * Remove the power star from the actor's inventory or remove the item from the location to consume.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (map.locationOf(actor).getItems().contains(powerStar)){
            map.locationOf(actor).removeItem(powerStar);
        } else if (actor.getInventory().contains(powerStar)){
            actor.removeItemFromInventory(powerStar);
        }
        powerStar.consumedBy(actor, map);
        return menuDescription(actor);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player consumes PowerStar (10 turns left)"
     */
    @Override
    public String menuDescription(Actor actor) {
        if (powerStar.getTurn() == 1) {
            return actor + " consumes the " + powerStar + " (" + powerStar.getTurn() + " turn left)";
        }
        return actor + " consumes the " + powerStar + " (" + powerStar.getTurn() + " turns left)";
    }
}
