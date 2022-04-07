package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ResetAction extends Action {
    private ResetManager resetManager;

    @Override
    public String execute(Actor actor, GameMap map) {
        resetManager = ResetManager.getInstance();
        resetManager.run();
        return "GAME is reset";
    }

    @Override
    public String hotkey() {
        return "r";
    }


    @Override
    public String menuDescription(Actor actor) {
        return "Reset the game.";
    }
}
