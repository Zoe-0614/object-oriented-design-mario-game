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
import game.actions.SuicideAction;
import game.enemies.Enemy;
import game.enums.Status;
import game.items.Coin;

import java.util.Random;

/**
 * A little fungus guy.
 */
public class Goomba extends Enemy {
    /**
     * Constructor.
     *
     * @param location the location of Goomba
     */
    public Goomba(Location location) {
        super("Goomba", 'g', 20, location);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
            this.addCapability(Status.ENGAGED);
        }

        super.allowableActions(otherActor, direction, map);
        return actions;
    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
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
        return new IntrinsicWeapon(10, "kicks");
    }


}
