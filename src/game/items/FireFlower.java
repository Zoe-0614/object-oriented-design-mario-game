package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.enums.Status;

/**
 * Class representing a Fire Flower
 *
 * @author Loh Zhun Guan
 * @version 1.0
 */
public class FireFlower extends MagicalItem{

    /**
     * Constructor
     */
    public FireFlower(){
        super("FireFlower",'f',true);
        addAction(new ConsumeAction(this));
    }

    /**
     * The features after an Actor consumed Fire Flower
     *
     * @param actor The Actor who consumed the Magical Items
     * @param map   the map that contains this location
     */
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.FIRE_ATTACK)) {
            actor.addCapability(Status.ALREADY_FIRE_ATTACK);
        }
        else {
            actor.addCapability(Status.FIRE_ATTACK);
        }

    }




}
