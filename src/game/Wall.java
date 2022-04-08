package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

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
		actionList.add(new JumpAction(this, location, direction));
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
