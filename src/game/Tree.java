package game;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;

abstract public class Tree extends Ground implements JumpCapable, SpawnCapable {
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
        /*
        drop is just a signle method that makes no sense
        outside of for tree classes

        OVERKILL
        why would drop coin need to be

        an intereface

        Like lets say if tree's drop needs an extra parameter
        and we do an interface, then the power star's
        paramter will be affected since they both use
        the same interface but they both don't


         */

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

    // protected abstract void drop(Location location);
}
