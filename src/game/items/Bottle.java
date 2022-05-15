package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeBottleAction;
import java.util.Stack;

/**
 * Class representing the Bottle.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class Bottle extends Item {
    /**
     * A stack that stores the waters
     */
    private Stack<MagicalItem> fill;
    /**
     * A singleton reset manager instance
     */
    private static Bottle instance;

    /**
     * Constructor
     */
    public Bottle(){
        super("Bottle",'b',false);
        fill = new Stack<MagicalItem>();
        addAction(new ConsumeBottleAction(this));
    }

    /**
     * Get the singleton instance of reset manager
     * @return Bottle singleton instance
     */
    public static Bottle getInstance(){
        if(instance == null){
            instance = new Bottle();
        }
        return instance;
    }

    /**
     * Get the stack that filled up by magical waters
     * @return a Stack, that stores the magical waters
     */
    public Stack getFill() {
        return fill;
    }

    /**
     * Displays the waters that are stored in the stack
     *
     * @return a string, e.g.[Healing Water, Healing Water, Power Water]
     */
    public String toString(){
        return this.fill.toString();
    }

}
