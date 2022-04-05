package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;

public class Coin extends Item {
    private final int value;

    public Coin(int value){
        super("Coin",'$',false);
        this.value = value;
        Action action = new PickUpCoinAction(this);
        addAction(action);
    }

    public int getValue() {
        return value;
    }


}
