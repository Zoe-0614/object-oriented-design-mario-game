package game.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.enums.Status;

public class PiranhaPlant extends Enemy {
    /**
     * Constructor.
     * @param location    the Enemy's location
     */
    public PiranhaPlant(Location location) {
        super("Piranha Plant", 'Y', 150, location);
        getBehaviours().clear();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
            this.addCapability(Status.ENGAGED);
        }
        if (this.hasCapability(Status.ENGAGED) && otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            addBehaviours(5, new AttackBehaviour(otherActor, direction));
        }
        return actions;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(0, "chomps");
    }

    @Override
    public void resetInstance() {
        this.increaseMaxHp(50);
        this.heal(this.getMaxHp());
    }
}
