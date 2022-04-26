package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Special Action for Suicide (Cleaning the Gamemap).
 */
public class SuicideAction extends Action {
    /**
     * The actor performing suicide gets removed from the map.
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @param location The location the actor is on.
     * @return a suitable description to display in the UI
     */
//    public String execute(Actor target, GameMap map, Location location) {
//        map.removeActor(target);
//        return target + "suicides... at" + location.toString();
//    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return "Goomba is cleared from the map";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
