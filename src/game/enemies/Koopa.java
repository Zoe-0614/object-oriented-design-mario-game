package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackKoopaAction;
import game.enums.Status;
import game.items.SuperMushroom;
import game.Monologue;

import java.util.ArrayList;
import java.util.List;

/**
 * A reptilian mini-trooper.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public abstract class Koopa extends Enemy {
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
     * @param location the location of Koopa
     */
    public Koopa(String name, char displayChar, int hitPoints, Location location) {
        super(name, displayChar, hitPoints, location);
        this.addItemToInventory(new SuperMushroom());
        this.damage = 30;
        talkList.add("Never gonna make you cry!");
        talkList.add("Koopi koopi koopii~!");
        Monologue.addActor(this);
        Monologue.addTalkList(this,talkList);


    }

    /**
     * Allowable actions of Koopa
     *
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        ActionList finalActions = new ActionList();
        List<Item> inventory = otherActor.getInventory();
        boolean hasWrench = false;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getDisplayChar() == 'w') {
                hasWrench = true;
            }
        }
        if (!this.isConscious() && !hasWrench) {
            return actions;
        }
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackKoopaAction(this, direction));
            this.addCapability(Status.ENGAGED);
        }

        ActionList actions2 = super.allowableActions(otherActor, direction, map);
        finalActions.add(actions);
        finalActions.add(actions2);
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back
//        if (otherActor.hasCapability(Status.WRENCH) || this.getDisplayChar() != 'D') {
//            actions.add(new AttackKoopaAction(this, direction));
//        }
        return finalActions;
    }

    /**
     * Figure out what to do next.
     *
     * @param actions a list of actions
     * @param lastAction the last action of the action list
     * @param map the game map the Koopa is at
     * @param display display
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     * @return actions
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.isConscious()) {
            return super.playTurn(actions, lastAction, map, display);

        } else {
            this.setDisplayChar('D');
            return new DoNothingAction();
        }

    }

    /**
     * Creates and returns an intrinsic weapon.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(damage, "punches");
    }


}
