package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

public class Toad extends Actor {


    public Toad(String name, char displayChar,int hitpoints){
        super("Toad",'O',100);

    }

    //Add an action that allows talking to toad
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.ISPLAYER)){
            actions.add(new TalkingAction(this));
        }
        return actions;
    }

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display){
        return new DoNothingAction();

    }





}
