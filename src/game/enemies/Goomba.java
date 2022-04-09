package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enemies.Enemy;

import java.util.Random;

/**
 * A little fungus guy.
 */
public class Goomba extends Enemy {
	private Random rand;
	/**
	 * Constructor.
	 * @param location
	 */
	public Goomba(Location location) {
		super("Goomba", 'g', 20, location);
	}


	/**
	 * Figure out what to do next.
	 * @see Actor#playTurn(ActionList, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		super.playTurn(actions, lastAction, map, display);

		return new DoNothingAction();
	}

	/**
	 * Creates and returns an intrinsic weapon.
	 *
	 * @return a freshly-instantiated IntrinsicWeapon
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "kick");
	}


}
