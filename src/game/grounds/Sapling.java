package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.enums.Status;
import game.grounds.Tree;
import game.items.Coin;

import java.util.Random;

public class Sapling extends Tree {
    private int damage;
    private int chance;

    public Sapling(){
        super('t',10);
        this.damage = 20;
        this.chance = 80;
    }
    @Override
    public void drop(Location location){
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
        if (!actor.hasCapability(Status.INVINCIBLE)) {
            actionList.add(new JumpAction(this, location, direction));
        }
        return actionList;
    }

    @Override
    public String getName() {
        return "Sapling";
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getChance() {
        return chance;
    }
}


