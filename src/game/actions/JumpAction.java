package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;

import java.util.Random;

public class JumpAction extends Action {
    Location locationToJump;
    String direction;
    Ground ground;

    public JumpAction(Location location, String direction) {
        this.locationToJump = location;
        this.direction = direction;
        this.ground = locationToJump.getGround();
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        boolean isSuccess = false;
        int damage = 0;
        if (actor.hasCapability(Status.TALL)) {
            map.moveActor(actor, locationToJump);
            isSuccess = true;
        }
        else if (ground.getDisplayChar() == '#' || ground.getDisplayChar() == 't') {
            int jumpChance = new Random().nextInt(100);
            if (!(jumpChance < 20)) {
                map.moveActor(actor, locationToJump);
                isSuccess = true;
            } else {
                damage = 20;
                actor.hurt(damage);
            }
        }
        else if (ground.getDisplayChar() == '+') {
            int jumpChance = new Random().nextInt(100);
            if (!(jumpChance < 10)) {
                map.moveActor(actor, locationToJump);
                isSuccess = true;
            } else {
                damage = 10;
                actor.hurt(damage);
            }
        }
        else if (ground.getDisplayChar() == 'T') {
            int jumpChance = new Random().nextInt(100);
            if (!(jumpChance < 30)) {
                map.moveActor(actor, locationToJump);
                isSuccess = true;
            } else {
                damage = 30;
                actor.hurt(damage);
            }
        }

        if (isSuccess) {
            return actor + " jumped and is standing on top of " + ground.getClass().getSimpleName();
        }
        else {
            return "Failed the Jump! Received " + damage + " damage.";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " jumps to the " + direction + " " + ground.getClass().getSimpleName() +
                " at (" + locationToJump.x() + ", " + locationToJump.y() + ")";
    }
}
