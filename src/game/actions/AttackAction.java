package game.actions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enums.Status;
import game.items.Fire;

/**
 * Special Action for attacking other Actors.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;

	/**
	 * The direction of incoming attack.
	 */
	protected String direction;

	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 *
	 * @param target the Actor to attack
	 * @param direction the direction of incoming attack
	 */
	public AttackAction(Actor target, String direction) {
		this.target = target;
		this.direction = direction;
	}

	/**
	 * Attack the enemies.
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a suitable description to display in the UI
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		String result = "";
		//determine whether the target is conscious (used when instant kill)
		Weapon weapon = actor.getWeapon();

		if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
			return actor + " misses " + target + ".";
		}
		if (actor.hasCapability(Status.FIRE_ATTACK)){
			map.locationOf(target).addItem(new Fire());
//			System.out.println("FIRE ATTACK HIT!");
		}

		result += attack(actor);
		result += dropInventory(actor, map);
		return result;
	}

	public String attack(Actor actor) {
		Weapon weapon = actor.getWeapon();
		String result;
		if (actor.hasCapability(Status.INVINCIBLE)){
			target.resetMaxHp(0);
			result = actor + " instantly kills " + target;
		}
		else if (target.hasCapability(Status.INVINCIBLE)) {
			result = actor + " " + weapon.verb() + " " + target + " for 0 damage.";
		}
		else {
			int damage = weapon.damage();
			result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
			target.hurt(damage);
			if (target.hasCapability(Status.HOSTILE_TO_ENEMY) && target.hasCapability(Status.TALL)) {
				target.removeCapability(Status.TALL);
			}
		}
		return result;
	}

	public String dropInventory(Actor actor, GameMap map) {
		String result = "";
		if (!target.isConscious()) {
			ActionList dropActions = new ActionList();
			// drop all items
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction(actor));
			for (Action drop : dropActions)
				drop.execute(target, map);
			// remove actor
			map.removeActor(target);
			result += System.lineSeparator() + target + " is killed.";
		}
		return result;
	}

	/**
	 * Describe the action in a format suitable for displaying in the menu.
	 *
	 * @see Action#menuDescription(Actor)
	 * @param actor The actor performing the action.
	 * @return a string, e.g. "Mario attacks Goomba at {The direction of incoming attack}"
	 */
	@Override
	public String menuDescription(Actor actor) {
		if (actor.hasCapability(Status.FIRE_ATTACK)){
			return actor + " attacks " + target + " at " + direction + " with fire";
		}
		return actor + " attacks " + target + " at " + direction;
	}
}
