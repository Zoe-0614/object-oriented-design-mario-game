package game;


import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;

abstract public class Tree extends Ground {
    protected int age;
    /**
     * Constructor.
     *
     */
    public Tree(char displayChar,int age) {
        super(displayChar);
        this.age=(age);
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

    protected abstract void drop(Location location);



}
