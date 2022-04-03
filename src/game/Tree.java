package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;

abstract public class Tree extends Ground {
    private int age = 0;
    /**
     * Constructor.
     *
     */
    public Tree(char displayChar) {
        super(displayChar);
    }

    //For the trees to grow
    public void tick(Location location){
        super.tick(location);
        age ++;


        if (age == 10){
            location.setGround(new Sapling());

        }
        else if (age == 20){
            location.setGround(new Mature());
        }
        //After every tick, drop goomba, koopa etc
        drop(location);


    }

    protected abstract void drop(Location location);
//    private void drop(Location location){
//        Random random = new Random();
//        GameMap map = location.map();
//        int prob = random.nextInt(10);
//        //Sapling
//        if(age >= 10 && age<20){
//            //Drop $20
//            //only number can get is 0 which is 10% out of 10 other numbers
//            if (prob < 1){
//                location.addItem(new Coin());
//            }
//        }
//        //Mature
//        else if(age >= 20 ){
//            //Add Koopa
//            //Need to change prob to 15%
//            int probMature = random.nextInt(100);
//            if (probMature <= 15){
//                if (!location.containsAnActor()){
//                    location.addActor(new Koopa());
//                }
//
//            }
//            //Create new sprout
//            if (age >= 25 && age % 5 ==0){
//                //Get the map's max x and y, generate random value between them and set that to sprout
//                int width = map.getXRange().max();
//                int height = map.getYRange().max();
//                int randomX = random.nextInt(width);
//                int randomY = random.nextInt(height);
//                //Sprout spawn location = map[x][y]
//                Location spawn =map.at(randomX,randomY);
//                //Check if the ground is dirt
//                if (spawn.getDisplayChar() == '.'){
//                    location.setGround(new Tree());
//                }
//
//
//            }
//            //20% to wither and die(become dirt)
//            if (probMature < 20){
//                location.setGround(new Dirt());
//            }
//
//        }
//        //Sprout
//        else{
//            //Add Goomba (10% to spawn)
//            if (prob < 1){
//                if (!location.containsAnActor()){
//                    location.addActor(new Goomba());
//                }
//            }
//
//        }
//
//    }



}
