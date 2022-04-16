package game.grounds;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.JumpCapable;
import game.capabilities.SpawnCapable;
import game.reset.Resettable;

import java.util.Random;

abstract public class Tree extends Ground implements JumpCapable, Resettable, SpawnCapable {
    protected int age;
    /**
     * Constructor.
     *
     */
    public Tree(char displayChar,int age) {
        super(displayChar);
        this.age=(age);
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    //For the trees to grow
    public void tick(Location location){
        super.tick(location);
        age ++;
//        System.out.println("age:"+age);
        if (age == 10){
            location.setGround(new Sapling());

        }
        else if (age == 20){
            location.setGround(new Mature());
//            System.out.println("Successfully set ground to Mature");
        }
        //After every tick, drop goomba, koopa etc
        drop(location);


    }


    @Override
    public void resetInstance() {
        int rand = new Random().nextInt(2);
        if(rand == 0){

        }
    }

}
