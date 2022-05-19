package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.FreePrincessPeachAction;
import game.enums.Status;

import java.util.ArrayList;

public class PrincessPeach extends Actor {

    /**
     * List of monologue script
     */
    private ArrayList<String> talkList = new ArrayList();

    /**
     * Constructor.
     */
    public PrincessPeach() {
        super("Princess Peach", 'P', 100);
        talkList.add("Dear Mario, I'll be waiting for you...");
        talkList.add("Never gonna give you up!");
        talkList.add("Release me, or I will kick you");
        Monologue.addActor(this);
        Monologue.addTalkList(this,talkList);
    }

    /**
     * Allowable actions of Princess Peach.
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        boolean hasKey = false;
        for (int i = 0; i < otherActor.getInventory().size(); i++) {
            if (otherActor.getInventory().get(i).getDisplayChar() == 'k') {
                hasKey = true;
            }
        }
        if (otherActor.hasCapability(Status.ISPLAYER) && hasKey) {
            actions.add(new FreePrincessPeachAction());
        }
        return actions;
    }

    /**
     * Figure out what to do next.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return actions, DoNothingAction in this case
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Monologue.addTurn(this, 1);
        if (Monologue.getTurn(this) % 2 == 0){
            Monologue.talk(this);
        }
        return new DoNothingAction();
    }
}
