package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.enums.Status;

public class SuperMushroom extends MagicalItem {
    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', false);
        addAction(new ConsumeAction(this));
    }

    @Override
    public void consumedBy(Actor actor, GameMap map) {
        actor.addCapability(Status.TALL);
        actor.increaseMaxHp(50);
    }


}
