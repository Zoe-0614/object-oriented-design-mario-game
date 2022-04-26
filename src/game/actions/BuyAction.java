package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.capabilities.Buyable;
import game.enums.Status;

public class BuyAction extends Action {
    private Buyable buyableItem;

    public BuyAction(Buyable buyableItem) {
        this.buyableItem = buyableItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        boolean isBought;
        isBought = buyableItem.buy(actor);
        if (isBought) {
            return menuDescription(actor);
        }
        return "You do not have enough coins!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + buyableItem.toString() + " ($" + buyableItem.getPrice() + ")";
    }
}
