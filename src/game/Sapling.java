package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Sapling extends Tree{
    private int damage;

    public Sapling(){
        super('t',10);
        this.damage = 20;
    }
    @Override
    protected void drop(Location location){
        Random random = new Random();

        int prob = random.nextInt(100);
        //Sapling
        //Drop $20
        if (prob < 10){
            location.addItem(new Coin(20));
        }
    }

    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if (direction.equals("")) {
            return new ActionList();
        }
        ActionList actionList = new ActionList();
        actionList.add(new JumpAction(this, location, direction));
        return actionList;
    }

    @Override
    public boolean jump(Actor actor, Location locationToJump, GameMap map) {
        int jumpChance = new Random().nextInt(100);
        if (!(jumpChance < 20)) {
            map.moveActor(actor, locationToJump);
            return true;
        } else {
            actor.hurt(damage);
            return false;
        }
    }

    @Override
    public String getName() {
        return "Sapling";
    }

    @Override
    public int getDamage() {
        return damage;
    }
}


