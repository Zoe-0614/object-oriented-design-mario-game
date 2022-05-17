package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.TeleportCapable;
import game.grounds.WarpPipe;

public class TeleportAction extends Action {
    private TeleportCapable teleporter;
    private String destinationName;

    public TeleportAction(TeleportCapable teleporter, String destinationName) {
        this.teleporter = teleporter;
        this.destinationName = destinationName;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        teleporter.teleport(actor, map);
        return actor + " teleports to " + destinationName;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport to " + destinationName;
    }
}
