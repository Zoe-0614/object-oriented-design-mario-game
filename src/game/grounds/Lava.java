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

    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.getDisplayChar() != 'm' && actor.getDisplayChar() != 'M') {
            return false;
        }
        return true;
    }

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
