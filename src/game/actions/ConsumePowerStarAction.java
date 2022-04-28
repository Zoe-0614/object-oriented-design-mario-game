package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.PowerStar;

public class ConsumePowerStarAction extends Action {
    private PowerStar powerStar;

    public ConsumePowerStarAction(PowerStar powerStar) {
        this.powerStar = powerStar;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (map.locationOf(actor).getItems().contains(powerStar)){
            map.locationOf(actor).removeItem(powerStar);
        } else if (actor.getInventory().contains(powerStar)){
            actor.removeItemFromInventory(powerStar);
        }
        powerStar.consumedBy(actor, map);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        if (powerStar.getTurn() == 1) {
            return actor + " consumes the " + powerStar + " (" + powerStar.getTurn() + " turn left)";
        }
        return actor + " consumes the " + powerStar + " (" + powerStar.getTurn() + " turns left)";
    }
}
