package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.WarpPipe;

public class TeleportAction extends Action {
    private GameMap destinationMap;
    private Location destinationlocation;
    private String destinationName;

    public TeleportAction(GameMap destination, Location destinationLocation, String destinationName) {
        this.destinationMap = destination;
        this.destinationlocation = destinationLocation;
        this.destinationName = destinationName;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (destinationMap.isAnActorAt(destinationlocation)) {
            destinationMap.removeActor(destinationMap.getActorAt(destinationlocation));
        }
        Location prev = map.locationOf(actor);
        map.moveActor(actor, destinationlocation);
        WarpPipe warpPipe = (WarpPipe) destinationlocation.getGround();
        warpPipe.setDestinationLocation(prev);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport to " + destinationName;
    }
}
