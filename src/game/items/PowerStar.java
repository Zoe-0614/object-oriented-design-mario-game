package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.Dirt;
import game.enums.Status;

public class PowerStar extends MagicalItem {
    private int turn = 10;
    /***
     * Constructor.
     */
    public PowerStar() {
        super("PowerStar", '*', true);
    }


    /**
     * The features after an Actor consumed Power Star
     * @param actor The Actor who consumed Power Star
     * @param map the map that contains this location
     */
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        actor.heal(200);
        actor.addCapability(Status.INVINCIBLE);
        System.out.println("Mario is INVINCIBLE!");

        tick(map.locationOf(actor),actor);

        Ground ground = map.locationOf(actor).getGround();
        if (!(ground.getDisplayChar() == '.')){
            map.locationOf(actor).setGround(new Dirt());
            map.locationOf(actor).addItem((new Coin(5)));
        }
    }

    @Override
    public void tick(Location location, Actor actor) {
        super.tick(location);
        this.toString();
        turn--;
        if (turn == 0){
            actor.removeCapability(Status.INVINCIBLE);
            actor.removeItemFromInventory(this);
        }
    }

    @Override
    public String toString() {
        return "Mario consumes Power Star - " + turn + " turns remaining";
    }


}
