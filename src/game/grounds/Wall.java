package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.capabilities.JumpCapable;
import game.enums.Status;

import java.util.Random;

public class Wall extends Ground implements JumpCapable {
	private int damage;
	private int chance;

	public Wall() {
		super('#');
		this.damage = 20;
		this.chance = 80;
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
		if (!actor.hasCapability(Status.INVINCIBLE)) {
			actionList.add(new JumpAction(this, location, direction));
		}
		return actionList;
	}

	@Override
	public String getName() {
		return "Wall";
	}

	@Override
	public int getDamage() {
		return damage;
	}

	@Override
	public int getChance() {
		return chance;
	}
}
