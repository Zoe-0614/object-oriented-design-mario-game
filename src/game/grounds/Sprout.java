package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.enemies.Goomba;
import game.enums.Status;

import java.util.Random;

public class Sprout extends Tree{
    private int damage;
    private int chance;

    public Sprout(){
        super('+',-1);
        this.damage = 10;
        this.chance = 90;
    }


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
    public String getName() {
        return "Sprout";
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getChance() {
        return chance;
    }

    @Override
    public void resetInstance() {
        super.resetInstance();
    }

    @Override
    public void registerInstance() {
        super.registerInstance();
    }

    @Override
    public void drop(Location location) {
        //Add Goomba (10% to spawn)
        Random random = new Random();
        int prob = random.nextInt(100);
        if (prob < 10){
            if (!location.containsAnActor()){
                location.addActor(new Goomba(location));
            }
        }
    }
}
