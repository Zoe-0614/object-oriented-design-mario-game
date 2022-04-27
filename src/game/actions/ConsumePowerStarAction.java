package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.PowerStar;

public class ConsumePowerStarAction extends ConsumeAction {

    private PowerStar powerStar;

    public ConsumePowerStarAction(PowerStar powerStar) {
        super(powerStar);
        this.powerStar = powerStar;
    }

    @Override
    public String menuDescription(Actor actor) {
        if (powerStar.getTurn() == 1) {
            return actor + " consumes the " + powerStar + " (" + powerStar.getTurn() + " turn left)";
        }
        return actor + " consumes the " + powerStar + " (" + powerStar.getTurn() + " turns left)";
    }
}
