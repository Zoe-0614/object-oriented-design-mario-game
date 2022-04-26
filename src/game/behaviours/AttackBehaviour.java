package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actions.AttackKoopaAction;
import game.enums.Status;

import java.util.Random;

/**
 * Special Behaviour for enemies to attack other Actors.
 */
public class AttackBehaviour implements Behaviour {

    /**
     * The Actor that is to be attacked
     */
    protected Actor target;

    /**
     * The direction of incoming attack.
     */
    protected String direction;
    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     */
    public AttackBehaviour(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Attack the player automatically
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return null or DoNothingAction()
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return new AttackAction(target, direction);
//        Weapon weapon = actor.getWeapon();
//
//        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
//            return new FollowBehaviour(target).getAction(actor, map);
//        }
//
//        if(target.hasCapability(Status.INVINCIBLE)) {
//            target.hurt(0);
//            return new DoNothingAction();
//        }
//
//        else if (actor.hasCapability(Status.ENGAGED)) {
//            target.hurt(weapon.damage());
//            if(target.hasCapability(Status.TALL)) {
//                target.removeCapability(Status.TALL);
//            }
//
//            if (!target.isConscious()) {
//                ActionList dropActions = new ActionList();
//                // drop all items
//                for (Item item : target.getInventory())
//                    dropActions.add(item.getDropAction(actor));
//                for (Action drop : dropActions)
//                    drop.execute(target, map);
//                // remove actor
//                map.removeActor(target);
//            }
//        }
//
//        return null;
    }
}
