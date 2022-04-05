package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Sprout extends Tree{
    public Sprout(){
        super('+',0);

    }
    @Override
    protected void drop(Location location){
        //Add Goomba (10% to spawn)
        Random random = new Random();
        int prob = random.nextInt(100);
        if (prob < 10){
            if (!location.containsAnActor()){
                location.addActor(new Goomba());
            }
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

}
