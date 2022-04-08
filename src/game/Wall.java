package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Wall extends Ground implements JumpCapable {
	private int damage;

	public Wall() {
		super('#');
		this.damage = 20;
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	public ActionList allowableActions(Actor actor, Location location, String direction) {
		if (direction.equals("")) {
			return new ActionList();
		}
		ActionList actionList = new ActionList();
		actionList.add(new JumpAction(this, location, direction));
		return actionList;
	}

	@Override
	public boolean jump(Actor actor, Location locationToJump, GameMap map) {
		int jumpChance = new Random().nextInt(100);
		if (!(jumpChance < 20)) {
			map.moveActor(actor, locationToJump);
			return true;
		} else {
			actor.hurt(damage);
			return false;
		}
	}

	@Override
	public String getName() {
		return "Wall";
	}

	@Override
	public int getDamage() {
		return damage;
	}
}
