package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.behaviours.Buyable;
import game.enums.Status;

/**
 * Class representing a Wrench
 * A weapon specifically used to destroy Koopa's shell
 */
public class Wrench extends WeaponItem implements Buyable {
    private int price;

    /**
     * Constructor
     */
    public Wrench() {
        super("Wrench", 'w', 50, "destroys", 80);
        this.addCapability(Status.WRENCH);
        this.price = 200;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Item getItem() {
        return this;
    }
}
