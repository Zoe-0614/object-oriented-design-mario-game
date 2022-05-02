package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Special Action for Suicide (Cleaning the Gamemap).
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class SuicideAction extends Action {
    /**
     * The actor performing suicide gets removed from the map.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return actor + " is cleared from the map";
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return null
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
