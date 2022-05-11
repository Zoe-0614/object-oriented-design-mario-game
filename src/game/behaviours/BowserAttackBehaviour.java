package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BowserAttackAction;

public class BowserAttackBehaviour implements Behaviour {
    /**
     * The Actor that is to be attacked
     */
    protected Actor target;

    /**
     * The direction of incoming attack.
     */
    protected String direction;

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     * @param direction the direction to attack
     */
    public BowserAttackBehaviour(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        return new BowserAttackAction(target, direction);
    }
}
