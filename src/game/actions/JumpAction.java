package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.JumpCapable;
import game.enums.Status;

public class JumpAction extends Action {
    JumpCapable jumpCapableGround;
    Location locationToJump;
    String direction;

    public JumpAction(JumpCapable jumpCapableGround, Location location, String direction) {
        this.jumpCapableGround = jumpCapableGround;
        this.locationToJump = location;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        boolean isSuccess;
        if (actor.hasCapability(Status.TALL)) {
            map.moveActor(actor, locationToJump);
            isSuccess = true;
        } else {
            isSuccess = jumpCapableGround.jump(actor, locationToJump, map);
        }

        if (isSuccess) {
            return actor + " jumped and is standing on top of " + jumpCapableGround.getName() + ".";
        } else {
            return "Failed the Jump! Received " + jumpCapableGround.getDamage() + " damage.";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " jumps to the " + direction + " " + jumpCapableGround.getName() +
                " at (" + locationToJump.x() + ", " + locationToJump.y() + ")";
    }
}
