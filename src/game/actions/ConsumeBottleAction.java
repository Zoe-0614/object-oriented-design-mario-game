package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Bottle;
import game.items.MagicalItem;

import java.util.Stack;


public class ConsumeBottleAction extends Action{
    private Bottle bottle;
    private Stack<MagicalItem> waters;
    /**
     * Constructor.
     *
     * @param bottle the fountain water in the bottle to be consumed
     */
    public ConsumeBottleAction(Bottle bottle) {
        this.bottle = bottle;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        waters = bottle.getFill();
        MagicalItem water = waters.pop();
        water.consumedBy(actor,map);

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes bottle" + bottle;
    }
}
