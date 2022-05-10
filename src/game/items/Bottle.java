package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.Stack;

public class Bottle extends Item {
    private Stack fill;

    public Bottle(){
        super("Bottle",'b',false);
    }

    public Stack getFill() {
        return fill;
    }

    public String toString(){
        return this + getFill().toString();
    }

}
