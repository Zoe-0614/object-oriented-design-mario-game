package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;
import game.items.Wrench;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TalkingAction extends Action {
    //Toad
    protected Actor target;
    protected Random random = new Random();
    protected ArrayList<String> talkList = new ArrayList<>();

    public TalkingAction(Actor target){
        this.target=target;
        talkList.add("You might need a wrench to smash Koopa's hard shells");
        talkList.add("You better get back to finding the Power Stars.");
        talkList.add("The Princess is depending on you.");
        talkList.add("Being imprisoned in these walls can drive a fungus crazy :(");
    }

    public String execute(Actor actor, GameMap map){
        ArrayList<String> newTalk = new ArrayList<>(talkList);
        List<Item> inventory = actor.getInventory();
        boolean hasWrench = false;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getDisplayChar() == 'w') {
                hasWrench = true;
            }
        }

        //If actor has wrench powerstar
        //actor.getWeapon == null is wrong cause there is always fists
        if (hasWrench && (actor.hasCapability(Status.INVINCIBLE))) {
            newTalk.remove(1);
            newTalk.remove(0);
        }
        //If actor has Power Star ONLY
        else if((actor.hasCapability(Status.INVINCIBLE))){
            newTalk.remove(1);
        }
        //has wrench only
        else if (hasWrench){
            newTalk.remove(0);
        }
        int toadIndex = random.nextInt(newTalk.size());
//        Testing to talk to toad
//        System.out.println("ToadTalksize" +newToadTalk.size());
//        System.out.println("ArrayList" +newToadTalk);
//        System.out.println("Toad index"+toadIndex);
        return newTalk.get(toadIndex);

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks to " + target;
    }

}
