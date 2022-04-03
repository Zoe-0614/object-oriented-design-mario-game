package game;

import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Sprout extends Tree{
    public Sprout(){
        super('+');

    }
    @Override
    protected void drop(Location location){
        //Add Goomba (10% to spawn)
        Random random = new Random();
        int prob = random.nextInt(100);
        if (prob < 10){
            if (!location.containsAnActor()){
                location.addActor(new Goomba());
            }
        }

    }



}
