package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.enums.Status;
import game.Monologue;
import game.reset.Resettable;

import java.util.Map;
import java.util.TreeMap;

/**
 * An entity that is alive by having hit points. It also holds inventory that stores items.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public abstract class Enemy extends Actor implements Resettable{

    /**
     * A list of behaviours
     */
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour
    /**
     * The location of the enemy
     */
    protected Location location;
    /**
     * The intrinsic attack damage of the enemy
     */
    private int damage;

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
        this.damage = getIntrinsicWeapon().damage();
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
        if (this.hasCapability(Status.ENGAGED) && otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) &&
                map.locationOf(otherActor).getGround().getDisplayChar() != '_') {
            behaviours.put(9, new AttackBehaviour(otherActor, direction));
            behaviours.put(8, new FollowBehaviour(otherActor));
        }
        else {
            behaviours.clear();
            behaviours.put(10, new WanderBehaviour());
        }
        return actions;
    }

    /**
     * Figure out what to do next.
     *
     * @param actions a list of actions
     * @param lastAction the last action of the action list
     * @param map the game map the enemy is at
     * @param display display
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     * @return actions
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Monologue.addTurn(this, 1);
        if (Monologue.getTurn(this) % 2 == 0){
            Monologue.talk(this);
        }
        for (Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
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

    /**
     * Get behaviours from the behaviours TreeMap.
     * @return behaviours
     */
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

    /**
     * Creates and returns an intrinsic weapon.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    protected abstract IntrinsicWeapon getIntrinsicWeapon();

    /**
     * Reset the damage.
     */
    public void setDamage() {
        this.damage = this.damage + 15;
    }
}
