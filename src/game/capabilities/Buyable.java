package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Wallet;

/**
 * Buyable is an interface where items that can be bought can implement.
 *
 * @author Chua Shin Herh
 * @version 1.0
 */
public interface Buyable {
    /**
     * A default method for all Buy Capable items to use which performs the actual buy action.
     * @param actor The actor performing the purchase.
     * @return a boolean indicating whether the purchase has succeeded.
     */
    default boolean buy(Actor actor) {
        if (Wallet.getBalance(actor) < getPrice()) {
            return false;
        }
        Wallet.deductMoney(actor, getPrice());
        actor.addItemToInventory(getItem());
        return true;
    }

    /**
     * Returns the price of the Buyable item.
     * @return an integer which is the price of the Buyable item.
     */
    int getPrice();

    /**
     * Returns the item itself but of the Item type.
     * @return an Item object which is the item itself but of the Item type.
     */
    Item getItem();
}
