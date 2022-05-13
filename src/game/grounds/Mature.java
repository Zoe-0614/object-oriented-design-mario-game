package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.enemies.FlyingKoopa;
import game.enemies.Koopa;
import game.enemies.WalkingKoopa;
import game.enums.Status;
import game.grounds.Sprout;
import game.grounds.Tree;

import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Class representing Mature
 */
public class Mature extends Tree {
    private int damage;
    private int chance;

    /**
     * Constructor
     */
    public Mature(){
        super('T',20);
        this.damage = 30;
        this.chance = 70;
    }

    /**
     * Has a chance to spawn a Koopa
     * Spawns a new Sprout at its surrounding square every 5 turns
     * Has a chance to wither
     * @param location of the Mature
     */
    @Override
    public void drop(Location location) {
        Random random = new Random();
        GameMap map = location.map();
        int prob = random.nextInt(100);
        //Add Koopa
        if (prob < 15) {
            if (!location.containsAnActor()) {
                int probSpawn = random.nextInt(100);
                if (probSpawn < 50) {
                    location.addActor(new WalkingKoopa(location));
                }
                else{
                    location.addActor(new FlyingKoopa(location));
                }
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
                    spawn.getGround().tick(spawn);
                    isTree = false;
                }
            }
        }
//        20% to wither and die(become dirt)
        if (prob < 20){
            location.setGround(new Dirt());
        }
    }

    /**
     *  Counts the number of dirt available around the tree
     * @param location location of the tree
     * @return the number dirt available in the surrounding area of the tree
     */
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

    /**
     * Allowable actions of Mature
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return list of actions
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

    @Override
    public boolean jump(Actor actor, Location locationToJump, GameMap map) {
        int jumpChance = new Random().nextInt(100);
        if (!(jumpChance < 30)) {
            map.moveActor(actor, locationToJump);
            return true;
        } else {
            actor.hurt(damage);
            return false;
        }
    }

    /**
     * Return the name of the ground
     *
     * @return a string, "Mature"
     */
    @Override
    public String getName() {
        return "Mature";
    }

    /**
     * Return the damage value of Mature
     *
     * @return the damage of failing the jump
     */
    @Override
    public int getDamage() {
        return damage;
    }

    /**
     * Return the chance value of Mature
     * @return the chance of succeeding the jump
     */
    @Override
    public int getChance() {
        return chance;
    }
}
