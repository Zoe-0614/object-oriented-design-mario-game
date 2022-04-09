package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import game.actions.PickUpCoinAction;
import game.reset.Resettable;

public class Coin extends Item implements Resettable {
    private int value;
    public Coin(int value){
        super("Coin",'$',false);
        this.value = value;
        Action action = new PickUpCoinAction(this);
        addAction(action);
        registerInstance();
    }

    public int getValue() {
        return value;
    }

    @Override
    public void resetInstance() {

    }
}
