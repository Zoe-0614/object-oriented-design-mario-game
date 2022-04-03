package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;

public class Coin extends Item {
    public Coin(){
        super("Coin",'$',false);
        Action action = new PickUpCoinAction(this);
        addAction(action);

    }



}
