package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;

import java.util.Random;

/**
 * Special Behaviour for enemies to attack other Actors.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class AttackBehaviour implements Behaviour {

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
     * @param direction the direction to attack
     */
    public AttackBehaviour(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Attack the player automatically
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return null or DoNothingAction()
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        return new AttackAction(target, direction);
    }
}
