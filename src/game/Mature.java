package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Mature extends Tree{
    public Mature(){
        super('T',20);

    }

    @Override
    protected void drop(Location location) {
        Random random = new Random();
        GameMap map = location.map();
        int prob = random.nextInt(100);
        //Add Koopa
        if (prob < 15) {
            if (!location.containsAnActor()) {
                location.addActor(new Koopa());
            }
        }
        //Create new sprout
        if (age % 5 ==0) {
            //Get the map's max x and y, generate random value between them and set that to sprout
            boolean isTree = true;
            int dirtCount = countDirt(location);
            //If all surrounding squares are filled, stop loop
            if (dirtCount == 0){
                isTree = false;
            }
            while (isTree){
                int randomX;
                int randomY;
                do{
                    int currentX = location.x();
                    int currentY = location.y();

                    //Off set is (0,1,2)
                    int offsetX = random.nextInt(3);
                    //-1 because it is the surrounding square so when it adds offset it'll be (-1,0,1)
                    randomX = currentX - 1 + offsetX;

                    //Off set is (0,1,2)
                    int offsetY = random.nextInt(3);
                    //-1 because it is the surrounding square so when it adds offset it'll be (-1,0,1)
                    randomY = currentY - 1 + offsetY;

                //Check randomX(orY) is less than maxindex
                }while(randomX < 0 || randomY < 0 || randomX > location.map().getXRange().max() || randomY > location.map().getXRange().max());
                //While loop to make sure randomX and randomY is not < 0, otherwise it will go out of bound


                //Sprout spawn location = map[x][y]
                Location spawn = map.at(randomX, randomY);

                //If it is dirt, new sprout
                if (spawn.getDisplayChar() == '.') {
                    spawn.setGround(new Sprout());

                    isTree = false;
                }




            }
        }
//        20% to wither and die(become dirt)
//        if (prob < 20){
//            location.setGround(new Dirt());
//        }

    }
    //Calculate the dirtCount in the surrounding area
    public int countDirt(Location location){
//      From -1,0,1 (Surrounding Space)
        int originalX = location.x();
        int originalY = location.y();
        int locationX;
        int locationY;

        int dirtCount =0;
        for (int offsetX = -1; offsetX < 2; offsetX++){
            locationX = originalX +offsetX;
            locationX = max(locationX,0);
            locationX = min(locationX,location.map().getXRange().max());
            for (int offsetY = -1; offsetY < 2; offsetY++){
                locationY = originalY+offsetY;
                locationY = max(locationY,0);
                locationY = min(locationY, location.map().getYRange().max());
                GameMap gameMap = location.map();
                if (gameMap.at(locationX,locationY).getDisplayChar() == '.'){
                    dirtCount += 1;
                }
            }

        }

        return dirtCount;
    }

    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if (direction.equals("")) {
            return new ActionList();
        }
        ActionList actionList = new ActionList();
        actionList.add(new JumpAction(location, direction));
        return actionList;
    }
}
