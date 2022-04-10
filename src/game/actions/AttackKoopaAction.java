package game.actions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enemies.Enemy;
import game.items.SuperMushroom;
import game.items.Wrench;

/**
 * Special Action for attacking Koopa.
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
     */
    public AttackKoopaAction(Actor target, String direction) {
        this.target = target;
        this.direction=direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        Weapon weapon = actor.getWeapon();

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        System.out.println(actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.");
        target.hurt(damage);
        if (!target.isConscious()) {
            Wrench wrench = new Wrench();
            if (actor.getInventory().contains(wrench)){
                wrench.getDropAction(actor);
                //become super mushroom
                map.locationOf(target).addItem(new SuperMushroom());
                // remove actor
                map.removeActor(target);
            }
        }

        return menuDescription(target);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction;
    }

    public String menuDescription(Enemy target){
        return "Destroys " + target  + "'s shell";
    }
}
