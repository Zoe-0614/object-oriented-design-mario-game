package game;

import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Sapling extends Tree{
    public Sapling(){
        super('t',10);

    }
    @Override
    protected void drop(Location location){
        Random random = new Random();

        int prob = random.nextInt(100);
        //Sapling
        //Drop $20
//        if (prob < 10){
//            location.addItem(new Coin());
//        }
    }


}


