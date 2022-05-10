package game.fountains;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public abstract class MagicalFountain {
    private final String name;
    private char displayChar;

    public MagicalFountain(String name, char displayChar) {
        this.name = name;
        this.displayChar = displayChar;
    }

    public abstract void consumedBy(Actor actor, GameMap map);
}
