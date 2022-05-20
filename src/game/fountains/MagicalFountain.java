package game.fountains;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeWaterAction;
import game.actions.RefillAction;
import game.items.MagicalItem;

/**
 * Abstract base class representing a fountain produces an endless amount of water.
 * Each water from a fountain provides different effects that will help Mario in his journey.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public abstract class MagicalFountain extends Ground {
    /***
     * Indicate the name of the Magical Fountain
     */
    private final String name;

    /***
     * Indicate the remaining turns of the fountain to recharge water
     */
    protected int turn;


    /***
     * Constructor
     */
    public MagicalFountain(String name, char displayChar) {
        super(displayChar);
        this.name = name;
        this.turn = 6;
    }


    /**
     * Allowable actions of the MagicalFountain
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        if (location.getActor() != null) {
            if (location.getActor().getDisplayChar() == 'm' || location.getActor().getDisplayChar() == 'M') {
                actionList.add(new RefillAction(this));
            }
            else{
                System.out.println(new ConsumeWaterAction(this.getWater()).execute(actor, location.map()));
            }
        }

        return actionList;
    }

    /**
     * Inform Magical Fountain on the ground of the passage of time.
     * Replenish water once all water is drank or being filled up.
     *
     * This method is called once per turn.
     * @param location The location of the Magical Fountain.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (this.getWaterLeft() == 0) {
            turn--;
            if (turn == 0) {
                if (getName().equals("Health Fountain")) {
                    location.setGround(new HealthFountain());
                    turn = 6;
                }
                else {
                    location.setGround(new PowerFountain());
                    turn = 6;
                }
            }
        }
    }

    /**
     * The name of the Magical Fountain
     * @return a string, eg. Health Fountain
     */
    public String getName() {
        return name;
    }

    /**
     * An abstract method to get the water of the Magical Fountain
     * @return a water, eg. Power Water
     */
    public abstract MagicalItem getWater();

    /**
     * An abstract method to indicate the remaining water left in the Magical Fountain
     * @return an int, eg. 10
     */
    public abstract int getWaterLeft();

}
