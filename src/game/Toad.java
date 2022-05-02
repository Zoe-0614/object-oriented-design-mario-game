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

/**
 * Class representing Toad
 */
public class Toad extends Actor {

    /**
     * Constructor
     */
    public Toad(){
        super("Toad",'O',100);

    }

    /**
     * Allowable actions of Toad
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    //Add an action that allows talking to toad
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new BuyAction(new PowerStar()));
        actions.add(new BuyAction(new SuperMushroom()));
        actions.add(new BuyAction(new Wrench()));
        if(otherActor.hasCapability(Status.ISPLAYER)){
            actions.add(new TalkingAction(this));
        }
        return actions;
    }

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display){
        return new DoNothingAction();

    }





}
