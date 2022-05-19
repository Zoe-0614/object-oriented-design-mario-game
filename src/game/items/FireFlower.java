package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.enums.Status;

public class FireFlower extends MagicalItem{

    private int turn;
    /**
     * Constructor
     */
    public FireFlower(){
        super("FireFlower",'f',true);
        addAction(new ConsumeAction(this));
    }

    @Override
    public void consumedBy(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.FIRE_ATTACK)) {
            actor.addCapability(Status.ALREADY_FIRE_ATTACK);
        }
        else {
            actor.addCapability(Status.FIRE_ATTACK);
        }

    }

    public int getTurn() {
        return turn;
    }


}
