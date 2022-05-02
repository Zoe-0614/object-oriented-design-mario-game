package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.enums.Status;
import game.grounds.Tree;
import game.items.Coin;

import java.util.Random;

/**
 * Class representing Sapling
 */
public class Sapling extends Tree {
    private int damage;
    private int chance;

    /**
     * Constructor
     */
    public Sapling(){
        super('t',10);
        this.damage = 20;
        this.chance = 80;
    }


    /**
     * Has a chance to spawn a coin at the Sapling
     * @param location of the Sapling
     */
    @Override
    public void drop(Location location){
        Random random = new Random();

        int prob = random.nextInt(100);
        //Sapling
        //Drop $20
        if (prob < 10){
            location.addItem(new Coin(20, location));
        }
    }

    /**
     * Allowable actions of Sapling
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return action list
     */
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if (direction.equals("")) {
            return new ActionList();
        }
        ActionList actionList = new ActionList();
        if (!actor.hasCapability(Status.INVINCIBLE)) {
            actionList.add(new JumpAction(this, location, direction));
        }
        return actionList;
    }

    /**
     * Return the name of the ground
     *
     * @return a string, "Sapling"
     */
    @Override
    public String getName() {
        return "Sapling";
    }

    /**
     * Return the damage value if the actor fails to jump on the Sapling
     *
     * @return an integer, indicating the damage value
     */
    @Override
    public int getDamage() {
        return damage;
    }

    /**
     * Return the chance for jump to succeed
     *
     * @return an integer, indicating the chance
     */
    @Override
    public int getChance() {
        return chance;
    }
}


