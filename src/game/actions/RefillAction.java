package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.fountains.MagicalFountain;
import game.items.Bottle;
import game.items.MagicalItem;

import java.util.List;
import java.util.Stack;


public class RefillAction extends Action {

    /**
     * The Magical Fountain that will be filled
     */
    private final MagicalFountain magicalFountain;
    private Bottle bottle;
    private Actor actor;

    /**
     * Constructor.
     *
     * @param magicalFountain the fountain which water will be refill into the bottle
     * @param actor the actor which bottle will be refilled
     */
    public RefillAction(MagicalFountain magicalFountain, Actor actor) {
        this.magicalFountain = magicalFountain;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.getInventory().contains(bottle)){
            bottle.getFill().push(magicalFountain.getWater());
        }
        return menuDescription(actor);

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " refills bottle from" + magicalFountain.getName();
    }

}
