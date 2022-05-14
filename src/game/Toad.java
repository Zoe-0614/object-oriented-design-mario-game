package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BuyAction;
import game.actions.GiveBottleAction;
import game.actions.TalkingAction;
import game.enums.Status;
import game.items.Bottle;
import game.items.PowerStar;
import game.items.SuperMushroom;
import game.items.Wrench;

/**
 * Class representing Toad
 */
public class Toad extends Actor {
    /**
     * Check if Player has Bottle
     */
    boolean hasBottle;

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
     * @return list of actions
     */
    //Add an action that allows talking to toad
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new BuyAction(new PowerStar()));
        actions.add(new BuyAction(new SuperMushroom()));
        actions.add(new BuyAction(new Wrench()));
        for (int i = 0; i < otherActor.getInventory().size(); i++) {
            if (otherActor.getInventory().get(i).getDisplayChar() == 'b') {
                hasBottle = true;
            }
            if (hasBottle) {
                break;
            }
        }
        if (!hasBottle) {
            actions.add(new GiveBottleAction());
        }
        if(otherActor.hasCapability(Status.ISPLAYER)){
            actions.add(new TalkingAction(this));
        }
        return actions;
    }

    /**
     * Figure out what to do next.
     *
     * @param actions a list of actions
     * @param lastAction the last action of the action list
     * @param map the game map the Toad is at
     * @param display display
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     * @return actions, DoNothingAction in this case
     */
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display){
        return new DoNothingAction();

    }





}
