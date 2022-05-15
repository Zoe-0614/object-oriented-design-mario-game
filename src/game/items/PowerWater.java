package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.enemies.Enemy;

public class PowerWater extends MagicalItem{
    /***
     * Constructor.
     */
    public PowerWater() {
        super("Power Water", 'P', false);
    }

    @Override
    public void consumedBy(Actor actor, GameMap map) {
        if (actor.getDisplayChar() == 'm' || actor.getDisplayChar() == 'M'){
            Player mario =  (Player)actor;
            mario.setDamage();
        } else {
            Enemy enemy =  (Enemy) actor;
            enemy.setDamage();
        }
    }
}
