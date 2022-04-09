package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.enums.Status;
import game.enemies.Koopa;

public class Wall extends Ground {

	public Wall() {
		super('#');
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasCapability(Status.INVINCIBLE)){
			return true;
		}
		return false;
	}

	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	public ActionList allowableActions(Koopa actor, Location location, String direction) {
		if (direction.equals("")) {
			return new ActionList();
		}
		ActionList actionList = new ActionList();
		actionList.add(new JumpAction(location, direction));
		return actionList;
	}
}
