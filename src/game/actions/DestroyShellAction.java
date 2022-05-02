package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.SuperMushroom;

/**
 * Special Action for Destroying enemy's shell.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class DestroyShellAction extends Action {
    /**
     * The Actor that shell is to be destroyed
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * The map the target is on.
     */
    private GameMap map;


    /**
     * @param target the Actor that shell is to be destroyed
     * @param map the map the actor is on.
     * @param direction the direction of the target
     */
    public DestroyShellAction(Actor target, GameMap map, String direction) {
        this.target = target;
        this.map = map;
        this.direction = direction;
    }

    /**
     * Destroy target's shell if the player has Wrench and drop a Super Mushroom.
     *
     * @see Action#execute(Actor, GameMap)
     * @param target The actor who shell is destroyed.
     * @param map The map the target is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        Location location = map.locationOf(target);
        map.removeActor(target);
        location.addItem(new SuperMushroom());
        return target + "'s shell is destroyed, dropped a Super Mushroom!";
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Destroys Koopa's shell at {The direction of Koopa}"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " destroys " + target  + "'s shell at " + direction;
    }
}
