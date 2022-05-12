package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.MagicalItem;

public class ConsumeWaterAction extends Action {
    /**
     * The Magical Item that will be consumed
     */
    private final MagicalItem magicalItem;

    /**
     * Constructor.
     *
     * @param magicalItem the item to consume
     */
    public ConsumeWaterAction(MagicalItem magicalItem) {
        this.magicalItem = magicalItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        magicalItem.consumedBy(actor, map);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
