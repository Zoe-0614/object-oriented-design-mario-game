package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.capabilities.Buyable;
import game.enums.Status;

/**
 * Class representing the Power Star.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */

public class PowerStar extends MagicalItem implements Buyable {
    /***
     * Indicate the remaining turns of the Power Star
     */
    private int turn;
    /***
     * Indicate the price of the Power Star
     */
    private int price;
    /***
     * Determine whether the Power Star is just being picked up
     */
    private boolean justPickedUp;

    /***
     * Constructor.
     */
    public PowerStar() {
        super("Power Star", '*', true);
        this.price = 600;
        this.turn = 11;
        this.justPickedUp = false;
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

    }

    /**
     * Inform Power Star of the passage of time.
     * Add ConsumePowerStarAction to Power Star's allowable Action
     *
     * This method is called once per turn after being consumed.
     * @param location The location of the actor that consumed the Power Star.
     * @param actor  The actor that consumed the Power Star.
     */
    @Override
    public void tick(Location location, Actor actor) {
        turn--;
        if (!justPickedUp) {
            addAction(new ConsumeAction(this));
            justPickedUp = true;
        }
        if (turn == 0) {
            actor.removeItemFromInventory(this);
        }
    }

    /**
     * Inform Power Star on the ground of the passage of time.
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
     * Get the price of PowerStar
     *
     * @return an integer, indicating the price of the Power Star
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Get the Power Star
     *
     * @return an Item, returning this item(Power Star in this case)
     */
    @Override
    public Item getItem() {
        return this;
    }

    /**
     * Get the turns remaining for the PowerStar
     *
     * @return an integer, indicating the remaining turns left of the Power Star
     */
    public int getTurn() {
        return turn;
    }
}
