package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeBottleAction;
import game.actions.ConsumeSuperMushroomAction;
import game.actions.RefillAction;

import java.util.Stack;

public class Bottle extends Item {
    private Stack<MagicalItem> fill;

    public Bottle(){
        super("Bottle",'b',false);
        fill = new Stack<MagicalItem>();
        addAction(new ConsumeBottleAction(this));
    }

    /**
     * Get the bottle
     *
     * @return an Item, returning this item(Bottle in this case)
     */
    public Item getItem() {
        return this;
    }

    public Stack getFill() {
        return fill;
    }

    public String toString(){
        return this.fill.toString();
    }

}
