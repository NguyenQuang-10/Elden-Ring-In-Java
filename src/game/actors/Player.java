package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderactions.BuyAction;
import game.actions.traderactions.BuySellCapable;
import game.actions.traderactions.SellAction;
import game.items.*;
import game.reset.ResetManager;
import game.weapons.Club;
import game.reset.Resettable;
import game.utils.Status;

import java.util.ArrayList;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor implements Resettable, BuySellCapable {
	/**
	 * A menu used to display to user to choose the action to be performed
	 */
	private final Menu menu = new Menu();

	/**
	 * An arrayList to store the Runes held by Player
	 */
	private ArrayList<Rune> runes = new ArrayList<>();

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
		this.addItemToInventory(new FlaskOfCrimsonTears());
		ResetManager.getInstance().registerResettable(this);
	}

	/**
	 * At each turn, select a valid action to perform.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the valid action that can be performed in that iteration or null if no valid action is found
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		Location here = map.locationOf(this);

		for(Exit exit: here.getExits()) {
			Location destination = exit.getDestination();

			if (destination.containsAnActor() && destination.getActor().hasCapability(Status.TRADER)) {
				ArrayList<Purchaseable> purchaseables = TradeableList.getInstance().getPurchaseables();
				for (Purchaseable item: purchaseables) {
					actions.add(new BuyAction(item.purchaseItem(), item.getPurchasePrice(), this));
				}

				ArrayList<Sellable> sellables = TradeableList.getInstance().getSellables();
				for (WeaponItem weapon: getWeaponInventory()) {
					for (Sellable item: sellables) {
						if (item.toString().equals(weapon.toString())) {
							actions.add(new SellAction(weapon, item.getSellPrice(), this));
						}
					}
				}
			}
		}

		display.print(this + " has " + runeBalance() + " runes\n");
		display.print(this + " has " + this.printHp() + " hp\n");
		return menu.showMenu(this, actions, display);
	}

	/**
	 * Returns the default attack capability of Player without a weapon
	 * @return an IntrinsicWeapon
	 */
	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(11, "punches", 100);
	}

	/**
	 * Reset Player hp to maximum and drops all the Runes
	 * @param actor the Actor that triggered an entire game reset
	 * @param map current GameMap
	 * @return A description of the reset process
	 */
	@Override
	public String reset(Actor actor, GameMap map) {
		this.resetMaxHp(this.maxHitPoints);
		Location location = map.locationOf(actor);
		for (Rune rune: this.runes) {
			rune.setLocation(location);
			ResetManager.getInstance().registerResettable(rune);
			(new DropItemAction(rune)).execute(this, map);
		}
		return this + " has hp reset to max " + this.maxHitPoints;
	}

	/**
	 * gets the total value of Runes held by Player
	 * @return total value of Runes
	 */
	@Override
	public int runeBalance() {
		int balance = 0;
		for (Rune rune: this.runes) {
			balance += rune.getValue();
		}
		return balance;
	}

	/**
	 * Add Rune to the Player when the Player sells a weapon
	 * @param amount - the value of Rune to be added
	 */
	@Override
	public void addRuneBalance(int amount) {
		this.runes.add(new Rune(amount));
	}

	/**
	 * Remove the amount of Rune when Player buys a weapon
	 * @param amount the value of Rune to be subtracted
	 */
	@Override
	public void minusRuneBalance(int amount) {
		int balance = 0;
		if (amount <= this.runeBalance()) {
			balance = this.runeBalance() - amount;
			runes.clear();

			if (balance > 0) {
				runes.add(new Rune(balance));
			}
		}

	}

	/**
	 * Used to remove tradeable weapons (sold weapon) from Player
	 * @param weapon the weapon that is sold
	 */
	@Override
	public void removeFromInventory(WeaponItem weapon) {
		super.removeWeaponFromInventory(weapon);
	}

	/**
	 * Used to add tradeable weapons (bought weapon) to Player
	 * @param weapon the weapon that is sold
	 */
	@Override
	public void addToInventory(WeaponItem weapon) {
		super.addWeaponToInventory(weapon);
	}

	/**
	 * Checks if Player has the weapon or not
	 * @param weapon a weapon
	 * @return true if the Actor do have weapon in their inventory, false otherwise
	 */
	@Override
	public boolean isInInventory(WeaponItem weapon) {
		for (WeaponItem item1: this.getWeaponInventory()) {
			if (weapon == item1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Add Rune item to the Player
	 * @param rune Rune is the currency used in the game
	 */
	@Override
	public void addRune(Rune rune) {
		this.runes.add(rune);
	}
}
