package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.enums.Status;
import game.items.Key;
import game.Monologue;

import java.util.ArrayList;

public class Bowser extends Enemy{

    /**
     * List of monologue script
     */
    private ArrayList<String> talkList = new ArrayList();

    /**
     * Constructor.
     */
    public Bowser(Location location) {
        super("Bowser", 'B', 500, location);
        getBehaviours().clear();
        this.addItemToInventory(new Key());
        talkList.add("What was that sound? Oh, just a fire.");
        talkList.add("Princess Peach! You are formally invited... to the creation of my new kingdom!");
        talkList.add("Never gonna let you down!");
        talkList.add("Wrrrrrrrrrrrrrrrryyyyyyyyyyyyyy!!!!");
        Monologue.addActor(this);
        Monologue.addTalkList(this,talkList);
        addCapability(Status.FIRE_ATTACK);
    }

    /**
     * Allowable actions of Bowser.
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
            this.addCapability(Status.ENGAGED);
        }
        if (this.hasCapability(Status.ENGAGED) && otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) &&
                map.locationOf(otherActor).getGround().getDisplayChar() != '_') {
            addBehaviours(9, new AttackBehaviour(otherActor, direction));
            addBehaviours(8, new FollowBehaviour(otherActor));
        }
        return actions;
    }

    /**
     * Figure out what to do next.
     * @param actions a list of actions
     * @param lastAction the last action of the action list
     * @param map the game map the enemy is at
     * @param display display
     * @return the Action instance returned by the parent class
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * Creates and returns an intrinsic weapon.
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "punches");
    }

    /**
     * Reset Bowser.
     */
    @Override
    public void resetInstance() {
        if (!location.containsAnActor()) {
            location.map().moveActor(this, location);
        }
        else if (location.containsAnActor() && location.getActor() != this &&
                !location.getActor().hasCapability(Status.ISPLAYER)) {
            location.map().removeActor(location.getActor());
        }
        this.heal(this.getMaxHp());
        this.removeCapability(Status.ENGAGED);
        getBehaviours().clear();
    }
}
