package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PickUpCoinAction;
import game.reset.Resettable;

/**
 * Class representing the coin
 */
public class Coin extends Item implements Resettable {
    private int value;
    private Location location;

    /**
     *Constructor
     * @param value of the coin
     * @param location of the coin
     */
    public Coin(int value, Location location){
        super("Coin",'$',false);
        this.value = value;
        this.location = location;
        addAction(new PickUpCoinAction(this));
        registerInstance();
    }

    /**
     * Get the value of Coin
     *
     * @return an integer, indicating the value of the Coin
     */
    public int getValue() {
        return value;
    }

    /**
     * Reset the coins
     */
    @Override
    public void resetInstance() {
        location.removeItem(this);
    }
}
