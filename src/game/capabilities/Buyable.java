package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Wallet;

public interface Buyable {
    default boolean buy(Actor actor) {
        if (Wallet.getBalance(actor) < getPrice()) {
            return false;
        }
        Wallet.deductMoney(actor, getPrice());
        actor.addItemToInventory(getItem());
        return true;
    }

    int getPrice();
    Item getItem();
}
