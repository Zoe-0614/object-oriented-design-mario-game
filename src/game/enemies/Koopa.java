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
import game.behaviours.FollowBehaviour;
import game.enums.Status;

public class Koopa extends Enemy {
    /**
     * Constructor.
     */

    public Koopa(Location location) {
        super("Koopa", 'K', 100, location);
        this.addCapability(Status.NOT_DORMANT);
    }

    /**
     * At the moment, we only make it can be attacked by Player.
     * You can do something else with this method.
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     * @see Status#NOT_DORMANT
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if(this.hasCapability(Status.NOT_DORMANT)) {
            actions = super.allowableActions(otherActor, direction, map);
        }

        else if (this.getDisplayChar() == 'D'){
            if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                actions.add(new AttackKoopaAction(this, direction));
            }
        }
        return actions;
    }

    /**
     * Figure out what to do next.
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        super.playTurn(actions, lastAction, map, display);
        if (this.isConscious()) {
            for (game.behaviours.Behaviour Behaviour : getBehaviours().values()) {
                Action action = Behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }else{
            this.setDisplayChar('D');
            return new DoNothingAction();
        }
        return new DoNothingAction();
    }
    /**
     * Creates and returns an intrinsic weapon.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30, "punch");
    }


}
