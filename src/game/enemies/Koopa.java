package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.AttackKoopaAction;
import game.actions.DestroyShellAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.enums.Status;
import game.items.SuperMushroom;

/**
 * A reptilian mini-trooper.
 */
public class Koopa extends Enemy {
    /**
     * Constructor.
     *
     * @param location the location of Koopa
     */
    public Koopa(Location location) {
        super("Koopa", 'K', 100, location);
        this.addCapability(Status.NOT_DORMANT);
        this.addItemToInventory(new SuperMushroom());
    }

    /**
     * Allowable actions of Koopa
     *
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     * @see Status#NOT_DORMANT
     * @see Status#WRENCH
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackKoopaAction(this, direction));
            this.addCapability(Status.ENGAGED);
        }

        super.allowableActions(otherActor, direction, map);
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back
//        if (otherActor.hasCapability(Status.WRENCH) || this.getDisplayChar() != 'D') {
//            actions.add(new AttackKoopaAction(this, direction));
//        }
        return actions;
    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.isConscious()) {
            return super.playTurn(actions, lastAction, map, display);
//            for (game.behaviours.Behaviour Behaviour : getBehaviours().values()) {
//                Action action = Behaviour.getAction(this, map);
//                if (action != null)
//                    return action;
//            }
        } else {
            this.setDisplayChar('D');
            return new DoNothingAction();
        }
        //return new DoNothingAction();
    }

    /**
     * Creates and returns an intrinsic weapon.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30, "punches");
    }


}
