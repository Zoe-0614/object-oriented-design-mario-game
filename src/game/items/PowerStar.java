package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.ConsumePowerStarAction;
import game.capabilities.Buyable;
import game.grounds.Dirt;
import game.enums.Status;

/**
 * Class representing the Power Star.
 */

public class PowerStar extends MagicalItem implements Buyable {
    /***
     * Indicate the remaining turn of Power Star
     */
    private int turn;
    private int price;

    /***
     * Constructor.
     */
    public PowerStar() {
        super("Power Star", '*', true);
        addAction(new ConsumePowerStarAction(this));
        this.price = 600;
        this.turn = 11;
    }


    /**
     * The features after an Actor consumed Power Star
     *
     * @param actor The Actor who consumed Power Star
     * @param map   the map that contains this location
     */
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        actor.heal(200);
        if (actor.hasCapability(Status.INVINCIBLE)) {
            actor.addCapability(Status.ALREADY_INVINCIBLE);
        }
        else {
            actor.addCapability(Status.INVINCIBLE);
        }

        tick(map.locationOf(actor), actor);

//        Ground ground = map.locationOf(actor).getGround();
//        if (!(ground.getDisplayChar() == '.' || ground.getDisplayChar() == '_')) {
//            map.locationOf(actor).setGround(new Dirt());
//            map.locationOf(actor).addItem((new Coin(5)));
//        }
    }

    /**
     * Inform Power Star of the passage of time.
     *
     * This method is called once per turn after being consumed.
     * @param location The location of the actor that consumed the Power Star.
     * @param actor  The actor that consumed the Power Star.
     */
    @Override
    public void tick(Location location, Actor actor) {
        turn--;
        if (turn == 0) {
            //actor.removeCapability(Status.INVINCIBLE);
            actor.removeItemFromInventory(this);
        }
    }

    /**
     * Inform Power Star of the passage of time.
     *
     * This method is called once per turn.
     * @param location The location of the Power Star if it is on the ground.
     */
    @Override
    public void tick(Location location) {
        turn--;
        if (turn == 0) {
            location.removeItem(this);
        }
    }

    /**
     * Display the remaining turns left of the Power Star.
     *
     * @return a string, e.g. "Power Star - 10 turns remaining"
     */
//    @Override
//    public String toString() {
//        return super.toString() + " - " + turn + " turns remaining";
//    }


    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Item getItem() {
        return this;
    }

    public int getTurn() {
        return turn;
    }
}
