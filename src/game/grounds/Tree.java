package game.grounds;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.JumpCapable;
import game.capabilities.SpawnCapable;
import game.enums.Status;
import game.reset.Resettable;

import java.util.Random;

abstract public class Tree extends Ground implements JumpCapable, Resettable, SpawnCapable {
    protected int age;
    protected Location location;

    /**
     * Constructor
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param age age of the tree
     */
    public Tree(char displayChar,int age) {
        super(displayChar);
        this.age = age;
        registerInstance();
    }

    /**
     * Returns true if an Actor can enter this location.
     *
     * Actors can enter a location if the terrain is passable and there isn't an Actor there already.
     * Game rule. One actor per location.
     * @param actor the Actor who might be moving
     * @return true if the Actor can enter this location
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.INVINCIBLE)) {
            return true;
        }
        return false;
    }

    /**
     * Tree grows every age
     * @param location The location of the Ground
     */
    //For the trees to grow
    public void tick(Location location){
        super.tick(location);
        this.location = location;
        age++;
//        System.out.println("age:"+age);
        if (age == 10){
            location.setGround(new Sapling());

        }
        else if (age == 20){
            location.setGround(new Mature());
//            System.out.println("Successfully set ground to Mature");
        }
        //After every tick, drop goomba, koopa etc
        if (age > 0) {
            drop(location);
        }

    }

    /**
     * Reset capabilities, attributes of the tree.
     */
    @Override
    public void resetInstance() {
        int rand = new Random().nextInt(2);
        if (rand == 0) {
            location.setGround(new Dirt());
        }
    }

}
