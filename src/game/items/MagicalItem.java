package game.items;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;


public interface MagicalItem{

    void consumedBy(Actor actor, GameMap map);


}
