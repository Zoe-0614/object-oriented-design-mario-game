package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.Random;

public class TalkingAction extends Action {
    //Toad
    protected Actor target;
    protected Random random = new Random();
    protected ArrayList<String> toadTalk = new ArrayList<>();

    public TalkingAction(Actor target){
        this.target=target;
        toadTalk.add("You might need a wrench to smash Koopa's hard shells");
        toadTalk.add("You better get back to finding the Power Stars.");
        toadTalk.add("The Princess is depending on you.");
        toadTalk.add("Being imprisoned in these walls can drive a fungus crazy :(");
    }

    public String execute(Actor actor, GameMap map){
        ArrayList<String> newToadTalk = new ArrayList<>(toadTalk);


        //If actor has wrench powerstar
        //actor.getWeapon == null is wrong cause there is always fists
        if ((actor.getWeapon() instanceof Wrench) && (actor.hasCapability(Status.INVINCIBLE))) {
            newToadTalk.remove(1);
            newToadTalk.remove(0);
        }
        //If actor has Power Star ONLY
        else if((actor.hasCapability(Status.INVINCIBLE))){
            newToadTalk.remove(1); //"YO b
        }
        //has wrench only
        else if(actor.getWeapon() instanceof Wrench){
            newToadTalk.remove(0);
        }
        int toadIndex = random.nextInt(newToadTalk.size());
//        Testing to talk to toad
//        System.out.println("ToadTalksize" +newToadTalk.size());
//        System.out.println("ArrayList" +newToadTalk);
//        System.out.println("Toad index"+toadIndex);
        return newToadTalk.get(toadIndex);

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks to " + target;
    }

}
