package game.fountains;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeWaterAction;
import game.actions.RefillAction;
import game.items.HealingWater;
import game.items.MagicalItem;
import game.items.PowerWater;

import java.util.ArrayList;

public abstract class MagicalFountain extends Ground {
    /***
     * Indicate the name of the Magical Fountain
     */
    private final String name;

    /***
     * Indicate the remaining turns of the fountain to recharge water
     */
    protected int turn;
    /**
     * The location of the tree
     */
    protected Location location;

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
                actionList.add(new ConsumeWaterAction(this.getWater()));
            }
        }

        return actionList;
    }

    /**
     * Inform Magical Fountain on the ground of the passage of time.
     *
     * This method is called once per turn.
     * @param location The location of the Magical Fountain.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
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
     * Get the water of the Magical Fountain
     * @return a water, eg. Power Water
     */
    public abstract MagicalItem getWater();

    /**
     * Indicate the remaining water left in the Magical Fountain
     * @return an int, eg. 10
     */
    public abstract int getWaterLeft();

}
