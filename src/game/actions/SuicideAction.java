package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class SuicideAction {
    public String execute(Actor target, GameMap map, Location location) {
        map.removeActor(target);
        return target + "suicides... at" + location.toString();
    }
}
