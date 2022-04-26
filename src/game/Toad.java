package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BuyAction;
import game.actions.TalkingAction;
import game.enums.Status;
import game.items.PowerStar;
import game.items.SuperMushroom;
import game.items.Wrench;

public class Toad extends Actor {


    public Toad(){
        super("Toad",'O',100);

    }

    //Add an action that allows talking to toad
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.ISPLAYER)){
            actions.add(new TalkingAction(this));
        }
        actions.add(new BuyAction(new PowerStar()));
        actions.add(new BuyAction(new SuperMushroom()));
        actions.add(new BuyAction(new Wrench()));
        return actions;
    }

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display){
        return new DoNothingAction();

    }





}
