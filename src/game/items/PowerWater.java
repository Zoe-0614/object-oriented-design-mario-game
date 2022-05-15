package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.enemies.Enemy;

/**
 * When the water is consumed, it increases the drinker's base/intrinsic attack damage by 15.
 *
 * @author Zoe Low Pei Ee
 * @version 1.0
 */
public class PowerWater extends MagicalItem{
    /***
     * Constructor.
     */
    public PowerWater() {
        super("Power Water", 'P', false);
    }

    /**
     * A method to execute the features after an Actor consumed Power water
     *
     * @param actor The Actor who consumed the Power Water
     * @param map   the map that contains this location
     */
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
