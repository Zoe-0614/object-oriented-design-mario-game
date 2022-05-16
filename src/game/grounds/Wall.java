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

/**
 * Class representing the Wall
 */
public class Wall extends Ground implements JumpCapable {
	private int damage;
	private int chance;

	/**
	 * Constructor
	 */
	public Wall() {
		super('#');
		this.damage = 20;
		this.chance = 80;
	}

	/**
	 * Checks if the actor enter can enter the wall
	 * @param actor the Actor to check
	 * @return a boolean, indicating if the actor can enter the wall
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasCapability(Status.INVINCIBLE) || actor.getDisplayChar() =='F') {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	/**
	 * Allowable actions of the wall
	 * @param actor the Actor acting
	 * @param location the current Location
	 * @param direction the direction of the Ground from the Actor
	 * @return list of actions
	 */
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

	/**
	 * Returns the name of the ground
	 * @return a string "Wall"
	 */
	@Override
	public String getName() {
		return "Wall";
	}

	/**
	 * Returns the damage value of the Wall
	 * @return the damage of failing the jump
	 */
	@Override
	public int getDamage() {
		return damage;
	}

	/**
	 * Returns the chance value of the wall
	 * @return the chance of succeeding the jump
	 */
	@Override
	public int getChance() {
		return chance;
	}
}
