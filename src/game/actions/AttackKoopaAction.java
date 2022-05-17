package game.actions;

import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enemies.Enemy;
import game.enums.Status;
import game.items.Fire;
import game.items.SuperMushroom;
import game.items.Wrench;

/**
 * Special Action for attacking Koopa.
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class AttackKoopaAction extends Action {

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
     * @param direction the direction to attack
     */
    public AttackKoopaAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Attack Koopa and destroy its shell if the player has Wrench.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Weapon weapon = actor.getWeapon();
        String result = "";

        if (target.isConscious()) {
            if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                return actor + " misses " + target + ".";
            }
            if (actor.hasCapability(Status.FIRE_ATTACK)){
                map.locationOf(target).addItem(new Fire());
//                System.out.println("FIRE ATTACK HIT!");
            }
            if (actor.hasCapability(Status.INVINCIBLE)) {
                result += actor + " instantly kills " + target;
                result += System.lineSeparator() + new DestroyShellAction(target, map, direction).execute(target, map);
            }
            else {
                int damage = weapon.damage();
                result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
                target.hurt(damage);
            }
        }
        else {
                result += new DestroyShellAction(target,map,direction).execute(target, map);
        }

        return result;
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Mario attacks Koopa at {The direction of incoming attack}"
     */
    @Override
    public String menuDescription(Actor actor) {
        if (target.isConscious()) {
            if (actor.hasCapability(Status.FIRE_ATTACK)){
                return actor + " attacks " + target + " at " + direction + " with fire";
            }
            return actor + " attacks " + target + " at " + direction;
        }
        return actor + " destroys " + target + " (Dormant)";
    }
}
