package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class PowerStar extends MagicalItem{
    protected int turn = 10;

    public PowerStar(int turn){
        super("Power Star",'*',true);
        Action action = new PickUpItemAction(this);
        addAction(action);
    }

    //Removes PowerStar from the ground
    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        turn--;

        if(turn == 0){
            currentLocation.removeItem(this);
        }

    }

    @Override
    public void consumedBy(Actor actor, GameMap map){
        actor.addCapability(Status.INVINCIBLE);
    }



}
