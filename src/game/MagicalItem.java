package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public abstract class MagicalItem extends Item {

    private int turn =10;

    /***
     * Constructor.
     *
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public MagicalItem(String name, char displayChar, boolean portable) {
        super(name,displayChar,portable);
    }

    //Remove Item from inventory
    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation);
        turn--;

        if(turn == 0){
            actor.removeItemFromInventory(this);
        }


    }
    public abstract void consumedBy(Actor actor, GameMap map);






}
