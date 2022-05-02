package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground {

	/**
	 * Constructor
	 */
	public Floor() {
		super('_');
	}

	/**
	 * Returns true if an Actor can enter this location.
	 *
	 * Actors can enter a location if the terrain is passable and there isn't an Actor there already.
	 * Game rule. One actor per location.
	 * @param actor the Actor who might be moving
	 * @return true if the Actor can enter this location
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.getDisplayChar() != 'm' && actor.getDisplayChar() != 'M') {
			return false;
		}
		return true;
	}
}
