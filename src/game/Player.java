package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.PickUpCoinAction;
import game.enums.Status;
import game.grounds.Dirt;
import game.items.Coin;
import game.reset.ResetAction;
import game.reset.Resettable;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable{

	private final Menu menu = new Menu();
	private int invincibleTimer;
	private int fireAttackTimer;
	private boolean resetState;
	private int damage;


	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.invincibleTimer = 10;
		this.fireAttackTimer = 20;
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.ISPLAYER);
//		this.addCapability(Status.FIRE_ATTACK);
		this.damage = 5;

		Wallet.addActor(this);
		registerInstance();
		resetState = false;
	}

	/**
	 * Figure out what to do next.
	 *
	 * @param actions a list of actions
	 * @param lastAction the last action of the action list
	 * @param map the game map the player is at
	 * @param display display
	 * @see Actor#playTurn(ActionList, Action, GameMap, Display)
	 * @return actions
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		if (!this.hasCapability(Status.RESET)) {
			actions.add(new ResetAction());
		}
		String hp = printHp();
		Location actorLocation = map.locationOf(this);
		//Player Status
		System.out.println(name + hp +" at " + "(" + actorLocation.x() + "," + actorLocation.y() + ")");
		//Wallet
		System.out.println("Wallet: $"+ Wallet.getBalance(this));
		if (this.hasCapability(Status.INVINCIBLE)) {
			if (this.hasCapability(Status.ALREADY_INVINCIBLE)) {
				invincibleTimer = 10;
				this.removeCapability(Status.ALREADY_INVINCIBLE);
			}
			System.out.println(this.name + " IS INVINCIBLE!");
			invincibleTimer--;
			Ground ground = map.locationOf(this).getGround();
			if (!(ground.getDisplayChar() == '.' || ground.getDisplayChar() == '_' || ground.getDisplayChar() == 'C')) {
				map.locationOf(this).setGround(new Dirt());
				Coin coin = new Coin(5, actorLocation);
				map.locationOf(this).addItem(coin);
				actions.add(new PickUpCoinAction(coin));
			}
		}

		if (invincibleTimer == 0) {
			this.removeCapability(Status.INVINCIBLE);
		}
		//Fire attack effect timer and check capability
		if (this.hasCapability(Status.FIRE_ATTACK)){
			if (this.hasCapability(Status.ALREADY_FIRE_ATTACK)){
				fireAttackTimer = 20;
				this.removeCapability(Status.ALREADY_FIRE_ATTACK);
			}
			System.out.println(this.name + " has FIRE ATTACK!");
			fireAttackTimer --;
//			System.out.println("Fire attack timer:" +fireAttackTimer);
		}
		if (fireAttackTimer == 0){
			this.removeCapability(Status.FIRE_ATTACK);
		}
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**Get the display character of the player
	 *
	 * @return a character that will be displayed on the game console
	 */
	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	/**
	 * Reset capabilities, attributes of the player.
	 */
	@Override
	public void resetInstance() {
		this.resetMaxHp(this.getMaxHp());
		this.removeCapability(Status.INVINCIBLE);
		this.removeCapability(Status.TALL);
	}

	/**
	 * Creates and returns an intrinsic weapon.
	 *
	 * @return a freshly-instantiated IntrinsicWeapon
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(damage, "punches");
	}

	/**
	 * Reset the damage.
	 */
	public void setDamage() {
		this.damage = this.damage + 15;
	}
}
