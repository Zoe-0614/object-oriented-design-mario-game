package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.PeachInteractAction;
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
            actions.add(new PeachInteractAction());
        }
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Monologue.addTurn(this, 1);
        if (Monologue.getTurn(this) % 2 == 0){
            Monologue.talk(this);
        }
        return new DoNothingAction();
    }
}
