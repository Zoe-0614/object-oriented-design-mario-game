package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.capabilities.Buyable;
import game.enums.Status;

/**
 * BuyAction is a class that handles the buying actions of actors when they want to buy something.
 *
 * @author Chua Shin Herh
 * @version 1.0
 */
public class BuyAction extends Action {
    private Buyable buyableItem;

    /**
     * A constructor for the BuyAction class.
     * @param buyableItem The item that can be bought.
     */
    public BuyAction(Buyable buyableItem) {
        this.buyableItem = buyableItem;
    }

    /**
     * Perform the Buy Action.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the item that is bought with the price if the actor has enough money, a failure message if the actor
     *          does not have enough money to buy the item.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        boolean isBought;
        isBought = buyableItem.buy(actor);
        if (isBought) {
            return menuDescription(actor);
        }
        return "You do not have enough coins!";
    }

    /**
     * Returns a string to show in the menu for the Buy Action.
     * @param actor The actor performing the action.
     * @return the text we put on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + buyableItem + " ($" + buyableItem.getPrice() + ")";
    }
}
