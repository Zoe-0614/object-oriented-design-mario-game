package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.SuperMushroom;

public class DestroyShellAction extends Action {
    private Actor target;
    private GameMap map;
    private String direction;

    public DestroyShellAction(Actor target, GameMap map, String direction) {
        this.target = target;
        this.map = map;
        this.direction = direction;
    }


    @Override
    public String execute(Actor target, GameMap map) {
        Location location = map.locationOf(target);
        map.removeActor(target);
        location.addItem(new SuperMushroom());

        return target  + "'s shell is destroyed, dropped a Super Mushroom!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Destroys " + target  + "'s shell at " + direction;
    }
}
