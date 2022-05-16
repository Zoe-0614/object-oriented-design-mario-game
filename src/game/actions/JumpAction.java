package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.JumpCapable;
import game.enums.Status;

/**
 * JumpAction is a class that handles the jumping actions of actors to high grounds.
 *
 * @author Chua Shin Herh
 * @version 1.0
 */
public class JumpAction extends Action {
    private JumpCapable jumpCapableGround;
    private Location locationToJump;
    private String direction;

    /**
     * A constructor for the JumpAction class.
     * @param jumpCapableGround The ground that can be jumped to.
     * @param location The location to jump to.
     * @param direction The direction of the location to jump from the actor.
     */
    public JumpAction(JumpCapable jumpCapableGround, Location location, String direction) {
        this.jumpCapableGround = jumpCapableGround;
        this.locationToJump = location;
        this.direction = direction;
    }

    /**
     * Perform the Jump Action.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a success message if the actor successfully jumped, a fail message if the actor failed the jump.
     */
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

    /**
     * Returns a string to show in the menu for the Jump Action.
     * @param actor The actor performing the action.
     * @return the text we put on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " jumps to the " + direction + " " + jumpCapableGround.getName() +
                " at (" + locationToJump.x() + ", " + locationToJump.y() + ")";
    }
}
