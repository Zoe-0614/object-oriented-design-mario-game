package game.fountains;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeWaterAction;
import game.actions.RefillAction;
import game.items.MagicalItem;

import java.util.ArrayList;

public abstract class MagicalFountain extends Ground {
    private final String name;
    private ArrayList<MagicalItem> waters =  new ArrayList<>();

    public MagicalFountain(String name, char displayChar) {
        super(displayChar);
        this.name = name;
    }

    @Override
    /**
     * Allowable actions of the MagicalFountain
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return list of actions
     */
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

    public String getName() {
        return name;
    }

    public abstract MagicalItem getWater();


    public abstract int getWaterLeft();

}
