package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.BowserAttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.enums.Status;
import game.items.Fire;
import game.items.Key;

public class Bowser extends Enemy{
    /**
     * Constructor.
     */
    public Bowser(Location location) {
        super("Bowser", 'B', 500, location);
        getBehaviours().clear();
        this.addItemToInventory(new Key());
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
            this.addCapability(Status.ENGAGED);
        }
        if (this.hasCapability(Status.ENGAGED) && otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) &&
                map.locationOf(otherActor).getGround().getDisplayChar() != '_') {
            addBehaviours(9, new BowserAttackBehaviour(otherActor, direction));
            addBehaviours(8, new FollowBehaviour(otherActor));
        }
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return super.playTurn(actions, lastAction, map, display);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(0, "punches");
    }

    @Override
    public void resetInstance() {

    }
}
