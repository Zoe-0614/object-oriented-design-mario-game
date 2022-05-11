package game.fountains;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.actions.RefillAction;

import java.util.List;

public abstract class MagicalFountain extends Ground {
    private final String name;

    public MagicalFountain(String name, char displayChar) {
        super(displayChar);
        this.name = name;
    }

    /**
     * Allowable actions of the MagicalFountain
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return list of actions
     */
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if (direction.equals("")) {
            return new ActionList();
        }
        ActionList actionList = new ActionList();
        if (actor.getDisplayChar() == 'm' || actor.getDisplayChar() == 'M') {
            actionList.add(new RefillAction(this, actor));
        }

        return actionList;
    }

    public String getName() {
        return name;
    }

}
