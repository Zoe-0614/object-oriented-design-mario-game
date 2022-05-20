package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Lava extends Ground {
    /**
     * Constructor.
     *
     *
     */
    public Lava() {
        super('L');
    }

    /**
     * Checks if the actor enter can enter lava.
     * @param actor the Actor to check
     * @return a boolean which indicates whether the actor can enter lava
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.getDisplayChar() != 'm' && actor.getDisplayChar() != 'M') {
            return false;
        }
        return true;
    }

    /**
     * Passes a turn for lava which deals damage to actors standing on it.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        Actor actor = location.getActor();
        if (actor != null) {
            int damage = 15;
            actor.hurt(damage);
            System.out.println(actor + " received " + damage + " damage from lava");
        }
    }
}
