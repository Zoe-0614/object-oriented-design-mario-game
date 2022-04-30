package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
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

    public int getValue() {
        return value;
    }

    @Override
    public void resetInstance() {
        location.removeItem(this);
    }
}
