package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class SuicideAction {
    public String execute(Actor target, GameMap map, String direction) {
        map.removeActor(target);
        return target + "suicides... at" + direction;
    }
}
