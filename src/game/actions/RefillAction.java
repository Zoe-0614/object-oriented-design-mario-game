package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.fountains.MagicalFountain;
import game.items.Bottle;

/**
 * Special Action for refilling the bottle.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class RefillAction extends Action {

    /**
     * The Magical Fountain which water will be filled into the bottle
     */
    private final MagicalFountain magicalFountain;
    /**
     * The Bottle that will be filled
     */
    private Bottle bottle;

    /**
     * Constructor.
     *
     * @param magicalFountain the fountain which water will be refill into the bottle
     */
    public RefillAction(MagicalFountain magicalFountain) {
        this.magicalFountain = magicalFountain;
        this.bottle = Bottle.getInstance();
    }

    /**
     * Fill up the bottle with the MagicalFountain's water.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.getInventory().contains(bottle)){
            bottle.getFill().push(magicalFountain.getWater());
        }
        return menuDescription(actor);

    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player refills bottle from HealthFountain (10/10)"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " refills bottle from " + magicalFountain.getName() + " (" + magicalFountain.getWaterLeft()+"/10)";
    }

}
