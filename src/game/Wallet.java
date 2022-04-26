package game;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;

public class Wallet {
    //Class variable
    private static HashMap<Actor, Integer> balance = new HashMap<>();

    //Maps the Actor to their starting balance
    public static void addActor(Actor actor) {
        balance.put(actor, 1000);
    }

    //Gets the player's money
    public static int getBalance(Actor actor) {
        if (balance.containsKey(actor)) {
            return balance.get(actor);
        } else {
            return 0;
        }
    }

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
