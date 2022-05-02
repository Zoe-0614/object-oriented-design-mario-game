package game;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;

/**
 * Class representing the number of coins the player has
 */

public class Wallet {
    //Class variable
    private static HashMap<Actor, Integer> balance = new HashMap<>();

    /**
     * Maps the Actor to their starting balance
     *
     * @param actor the actor who has a wallet
     */
    public static void addActor(Actor actor) {
        balance.put(actor, 2000);
    }

    /**
     * Gets the Money of the actor
     *
     * @param actor the Player
     * @return the amount of money the actor has
     */
    //Gets the player's money
    public static int getBalance(Actor actor) {
        if (balance.containsKey(actor)) {
            return balance.get(actor);
        } else {
            return 0;
        }
    }

    /**
     * Money increased after Player picks up the coin
     * @param actor the Player
     * @param money The amount of money the player has gained
     */
    //Getting the balance from the Actor and then adding the money
    public static void addMoney(Actor actor, int money) {
        int currBalance;
        if (balance.containsKey(actor)) {
            currBalance = balance.get(actor);
        } else {
            currBalance = 0;
        }
        int newBalance = currBalance + money;
        balance.put(actor, newBalance);
    }

    /**
     * Money decreased after Player uses it.
     *
     * @param actor the Player
     * @param money The amount of money the player has used
     */
    public static void deductMoney(Actor actor, int money) {
        int currBalance;
        if (balance.containsKey(actor)) {
            currBalance = balance.get(actor);
        } else {
            throw new IllegalArgumentException();
        }
        int newBalance = currBalance - money;
        balance.put(actor, newBalance);
    }


}
