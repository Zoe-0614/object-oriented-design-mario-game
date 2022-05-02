package game.items;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Abstract base class representing a physical magical items in the game world.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public abstract class MagicalItem extends Item {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public MagicalItem(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    /**
     * A method to indicate dropping the magical items
     *
     * @param actor The Actor who consumed the Magical Items
     */
    @Override
    public DropItemAction getDropAction(Actor actor) {
        return null;
    }

    /**
     * An abstract method to execute the features after an Actor consumed the Magical Items
     *
     * @param actor The Actor who consumed the Magical Items
     * @param map   the map that contains this location
     */
    public abstract void consumedBy(Actor actor, GameMap map);
}
