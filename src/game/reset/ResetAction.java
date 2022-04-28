package game.reset;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;

/**
 * Special Action to reset the game
 */
public class ResetAction extends Action {
    /**
     * A singleton reset manager instance
     */
    private ResetManager resetManager;

    /**
     * Reset the game.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        resetManager = ResetManager.getInstance();
        resetManager.run();
        actor.addCapability(Status.RESET);
        return "GAME is reset";
    }

    /**
     * Returns the key used in the menu to trigger this Action.
     *
     * @return The key we use for this Action in the menu.
     */
    @Override
    public String hotkey() {
        return "r";
    }


    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Reset the game."
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Reset the game.";
    }
}
