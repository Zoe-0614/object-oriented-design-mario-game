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

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

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

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    @Override
    public String getName() {
        return "Warp Pipe";
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getChance() {
        return chance;
    }

    @Override
    public Location getDestinationLocation() {
        return destinationLocation;
    }

    @Override
    public void resetInstance() {
        hasPiranhaPlant = false;
    }
}

