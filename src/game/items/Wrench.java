package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.capabilities.Buyable;

/**
 * Class representing a Wrench
 * A weapon specifically used to destroy Koopa's shell
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class Wrench extends WeaponItem implements Buyable {
    private int price;

    /**
     * Constructor
     */
    public Wrench() {
        super("Wrench", 'w', 50, "destroys", 80);
        this.price = 200;
    }

    /**
     * Get the price of Wrench
     *
     * @return an integer, indicating the price of the Wrench
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Get the Wrench
     *
     * @return an Item, returning this item(Wrench in this case)
     */
    @Override
    public Item getItem() {
        return this;
    }
}
