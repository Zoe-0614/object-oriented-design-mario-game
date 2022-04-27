package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.reset.ResetAction;
import game.reset.Resettable;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();
	private int invincibleTimer;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.ISPLAYER);
		//test for talking to toad
//		this.addCapability(Status.INVINCIBLE);
//		addItemToInventory(new Wrench());
		Wallet.addActor(this);
		registerInstance();
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		actions.add(new ResetAction());
		String hp = printHp();
		Location actorLocation = map.locationOf(this);

		//Player Status
		System.out.println(name + hp +" at " + "(" + actorLocation.x() + "," + actorLocation.y() + ")");
		//Wallet
		System.out.println("Wallet: $"+ Wallet.getBalance(this));
		if (!this.hasCapability(Status.INVINCIBLE)) {
			invincibleTimer = 10;
		}
		else if (this.hasCapability(Status.INVINCIBLE)) {
			System.out.println(this.name + " IS INVINCIBLE! (" + invincibleTimer + " turns left)");
			invincibleTimer--;
		}

		if (invincibleTimer == 0) {
			this.removeCapability(Status.INVINCIBLE);
		}
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}


	@Override
	public void resetInstance() {
		this.resetMaxHp(this.getMaxHp());
		this.removeCapability(Status.INVINCIBLE);
		this.removeCapability(Status.TALL);
	}

}
