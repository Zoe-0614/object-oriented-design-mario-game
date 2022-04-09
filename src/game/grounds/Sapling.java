package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.items.Coin;

import java.util.Random;

public class Sapling extends Tree {
    public Sapling(){
        super('t',10);

    }
    @Override
    protected void drop(Location location){
        Random random = new Random();

        int prob = random.nextInt(100);
        //Sapling
        //Drop $20
        if (prob < 10){
            location.addItem(new Coin(20));
        }
    }

    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if (direction.equals("")) {
            return new ActionList();
        }
        ActionList actionList = new ActionList();
        actionList.add(new JumpAction(location, direction));
        return actionList;
    }

    @Override
    public void resetInstance() {
        super.resetInstance();
    }

    @Override
    public void registerInstance() {
        super.registerInstance();
    }

}


