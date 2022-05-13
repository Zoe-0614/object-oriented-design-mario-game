package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Bottle;

public class GiveBottleAction extends Action {
    private Bottle bottle;
    /**
     * A constructor for the BuyAction class.
     */
    public GiveBottleAction() {
        this.bottle = Bottle.getInstance();
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (!actor.getInventory().contains(bottle)) {
            actor.addItemToInventory(this.bottle);
            return menuDescription(actor);
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " gets bottle from Toad";
    }
}
