package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.actions.TeleportAction;
import game.capabilities.JumpCapable;
import game.capabilities.TeleportCapable;
import game.enemies.PiranhaPlant;
import game.enums.Status;
import game.reset.Resettable;

public class WarpPipe extends Ground implements JumpCapable, Resettable, TeleportCapable {
    private int damage;
    private int chance;
    private boolean hasPiranhaPlant;
    private Location destinationLocation;
    private String destinationName;

    /**
     * Constructor.
     */
    public WarpPipe(Location destinationLocation, String destinationName) {
        super('C');
        this.damage = 0;
        this.chance = 100;
        this.hasPiranhaPlant = false;
        this.destinationLocation = destinationLocation;
        this.destinationName = destinationName;
        registerInstance();
    }

    /**
     * Checks if the actor enter can stand on the warp pipe.
     * @param actor the Actor to check
     * @return a boolean which indicates whether the actor can stand on the warp pipe
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    /**
     * Returns an action list which provides the actions that an actor can perform on the warp pipe.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return an action list which provides the actions that an actor can perform on the warp pipe
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        if (location.getActor() == null) {
            actionList.add(new JumpAction(this, location, direction));
        }
        else if (location.getActor() == actor) {
            actionList.add(new TeleportAction(this, destinationName));
        }
        return actionList;
    }

    /**
     * Passes a turn for warp pipe which spawns Piranha Plant at the first turn.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (location.containsAnActor() && !location.getActor().hasCapability(Status.ISPLAYER)) {
            hasPiranhaPlant = true;
        }
        else if (!hasPiranhaPlant) {
            location.addActor(new PiranhaPlant(location));
            hasPiranhaPlant = true;
        }
    }

    /**
     * Sets the destination location of the warp pipe.
     * @param destinationLocation the destination location of the warp pipe
     */
    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    /**
     * Returns the name of the Ground.
     * @return a string which is the name of the Ground
     */
    @Override
    public String getName() {
        return "Warp Pipe";
    }

    /**
     * Returns the damage dealt to the player if the player fails the jump to the JumpCapable Ground.
     * @return an integer which is the damage dealt to the player
     */
    @Override
    public int getDamage() {
        return damage;
    }

    /**
     * Returns the chance of the player jumping successfully on the warp pipe.
     * @return an integer which is the success chance of the jump of the player
     */
    @Override
    public int getChance() {
        return chance;
    }

    /**
     * Returns the destination location of the warp pipe.
     * @return a Location instance which is the destination location of the warp pipe.
     */
    @Override
    public Location getDestinationLocation() {
        return destinationLocation;
    }

    /**
     * Reset capabilities, attributes of the warp pipe.
     */
    @Override
    public void resetInstance() {
        hasPiranhaPlant = false;
    }
}

