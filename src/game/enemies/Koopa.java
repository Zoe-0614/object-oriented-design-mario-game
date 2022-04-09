package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class Koopa extends Enemy {
    /**
     * Constructor.
     */

    public Koopa(Location location) {
        super("Koopa", 'K', 100, location);
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
