package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.enums.Status;
import game.reset.Resettable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * An entity that is alive by having hit points. It also holds inventory that stores items.
 */
public abstract class Enemy extends Actor implements Resettable {

    /**
     * A list of behaviours
     */
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour
    /**
     * The location of the enemy
     */
    protected Location location;

    /**
     * Constructor.
     *
     * @param name        the name of the Enemy
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Enemy's starting hit points
     * @param location    the Enemy's location
     */
    public Enemy(String name, char displayChar, int hitPoints, Location location) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(10, new WanderBehaviour());
        this.location = location;
        registerInstance();
    }


    /**
     * Allowable actions of the enemy
     *
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     * @see Status#HOSTILE_TO_ENEMY
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
            this.addCapability(Status.ENGAGED);
        }

        if (this.hasCapability(Status.ENGAGED)) {
            behaviours.put(8, new AttackBehaviour(otherActor, direction));
            behaviours.put(9, new FollowBehaviour(otherActor));
        }
        return actions;
    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }


    /**
     * Add new behaviours into the behaviours TreeMap.
     *
     * @param priority the priority of the behaviour
     * @param behaviour the behaviour to be added
     */
    public void addBehaviours(int priority, Behaviour behaviour) {
        behaviours.put(priority, behaviour);
    }

    public Map<Integer, Behaviour> getBehaviours() {
        return behaviours;
    }


    /**
     * Reset the enemies.
     */
    @Override
    public void resetInstance() {
        GameMap map = location.map();
        map.removeActor(this);
    }
}
