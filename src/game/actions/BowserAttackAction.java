package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enums.Status;
import game.items.Fire;

import java.util.Random;

public class BowserAttackAction extends AttackAction {
    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param direction the direction of incoming attack
     */
    public BowserAttackAction(Actor target, String direction) {
        super(target, direction);
    }

    /**
     * Executes the attack action of Bowser.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a String which displays the attack done by Bowser in the log
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        //determine whether the target is conscious (used when instant kill)
        Weapon weapon = actor.getWeapon();

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }
        else {
            result += attack(actor);
            map.locationOf(target).addItem(new Fire());
        }

        result += dropInventory(actor, map);
        return result;
    }

    /**
     * The menu description of Bowser's attack.
     * @param actor The actor performing the action.
     * @return a String which is the menu description of Bowser's attack.
     */
    @Override
    public String menuDescription(Actor actor) {
        return super.menuDescription(actor);
    }
}
