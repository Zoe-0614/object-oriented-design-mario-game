package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class FreePrincessPeachAction extends Action {
    /**
     * Executes the end game.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a String containing a victory message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return "Victory!";
    }

    /**
     * The menu description of the action to save Princess Peach.
     * @param actor The actor performing the action.
     * @return a String which is the menu description of the action to save Princess Peach.
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Save Princess Peach";
    }
}
