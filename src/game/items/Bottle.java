package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeBottleAction;
import game.reset.ResetManager;

import java.util.Stack;

public class Bottle extends Item {
    private Stack<MagicalItem> fill;
    /**
     * A singleton reset manager instance
     */
    private static Bottle instance;

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


    public Stack getFill() {
        return fill;
    }

    public String toString(){
        return this.fill.toString();
    }

}
