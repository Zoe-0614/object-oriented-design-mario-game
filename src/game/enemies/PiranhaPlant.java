package game.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.enums.Status;
import game.Monologue;

import java.util.ArrayList;

public class PiranhaPlant extends Enemy {
    /**
     * List of monologue script
     */
    private ArrayList<String> talkList = new ArrayList();

    /**
     * Constructor.
     * @param location    the Enemy's location
     */
    public PiranhaPlant(Location location) {
        super("Piranha Plant", 'Y', 150, location);
        getBehaviours().clear();
        talkList.add("Slsstssthshs~! (Never gonna say goodbye~)");
        talkList.add("Ohmnom nom nom nom.");
        Monologue.addActor(this);
        Monologue.addTalkList(this,talkList);
    }


    /**
     * Allowable actions of Piranha Plant.
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
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

    /**
     * Creates and returns an intrinsic weapon.
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(90, "chomps");
    }

    /**
     * Reset Piranha Plant.
     */
    @Override
    public void resetInstance() {
        this.increaseMaxHp(50);
        this.heal(this.getMaxHp());
    }


}
