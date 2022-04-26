package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.behaviours.Buyable;
import game.enums.Status;

/**
 * Class representing the Super Mushroom.
 */

public class SuperMushroom extends MagicalItem implements Buyable {
    private int price;

    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', false);
        addAction(new ConsumeAction(this));
        this.price = 400;
    }

    /**
     * The features after an Actor consumed Super Mushroom
     *
     * @param actor The Actor who consumed Super Mushroom
     * @param map   the map that contains this location
     */
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        actor.addCapability(Status.TALL);
        actor.increaseMaxHp(50);
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
