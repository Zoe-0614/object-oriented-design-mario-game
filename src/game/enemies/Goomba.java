package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.SuicideAction;
import game.enums.Status;
import game.Monologue;

import java.util.ArrayList;
import java.util.Random;

/**
 * A little fungus guy.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class Goomba extends Enemy {
    /**
     * The intrinsic attack damage of the enemy
     */
    private int damage;

    /**
     * List of monologue script
     */
    private ArrayList<String> talkList = new ArrayList();

    /**
     * Constructor.
     *
     * @param location the location of Goomba
     */
    public Goomba(Location location) {
        super("Goomba", 'g', 20, location);
        this.damage = 10;
        talkList.add("Mugga mugga!");
        talkList.add("Ugha ugha...(Never gonna run around and desert you...)");
        talkList.add("Ooga-Chaka Ooga-Ooga!");
        Monologue.addActor(this);
        Monologue.addTalkList(this,talkList);

    }


    /**
     * Allowable actions of Goomba
     *
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

        actions.add(super.allowableActions(otherActor, direction, map));
        return actions;
    }

    /**
     * Figure out what to do next.
     *
     * @param actions a list of actions
     * @param lastAction the last action of the action list
     * @param map the game map the Goomba is at
     * @param display display
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     * @return actions
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Action action = super.playTurn(actions, lastAction, map, display);

        //10% chance: suicide
        Random random = new Random();
        int prob = random.nextInt(100);

        if (prob < 10) {
            //new SuicideAction().execute(this, map, this.location);
            SuicideAction suicide = new SuicideAction();
            suicide.execute(this, map);
            return suicide;
        }

        return action;
    }

    /**
     * Creates and returns an intrinsic weapon.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(damage, "kicks");
    }


}
