package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.Wallet;
import game.items.Coin;

/**
 * Action to allow coins to be picked up.
 */
public class PickUpCoinAction extends Action {

    private final Coin coin;

    /**
     * Constructor.
     *
     * @param coin the coin to pick up
     */
    public PickUpCoinAction(Coin coin) {
        this.coin = coin;
    }

    /**
     * Adds the coin to the actor's balance.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        //Create a player object by casting Actor to be Player
        Player player = (Player) actor;
        map.locationOf(actor).removeItem(coin);
        //Increase the balance of the player, need to use player object through actor
        Wallet.addMoney(actor, coin.getValue());
        return menuDescription(player);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the coin"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + coin + " ($" + coin.getValue() + ")";
    }
}
