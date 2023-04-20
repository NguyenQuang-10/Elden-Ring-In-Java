package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.traderactions.BuyAction;
import game.actions.traderactions.BuySellCapable;
import game.items.Purchaseable;
import game.items.Rune;
import game.items.TradeableList;
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

	private final Menu menu = new Menu();
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
		this.addWeaponToInventory(new Club());
	}

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
					if (runeBalance() <= item.getPurchasePrice()) {
						actions.add(new BuyAction(item.purchaseItem(), item.getPurchasePrice(), this));
						break;
					}
				}
			}
		}


		display.print(this + " has " + runeBalance() + " runes\n");
		display.print(this + " has [" + this.hitPoints + "/" + this.maxHitPoints + "] hp\n");
		return menu.showMenu(this, actions, display);
	}

	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(11, "punches", 100);
	}

	@Override
	public void reset() {}

	@Override
	public int runeBalance() {
		int balance = 0;
		for (Rune rune: this.runes) {
			balance += rune.getValue();
		}
		return balance;
	}

	@Override
	public void modifyRuneBalance(int amount) {
		int balance = 0;
		if (amount <= this.runeBalance()) {
			balance = this.runeBalance() - amount;
			runes.clear();

			if (balance > 0) {
				runes.add(new Rune(balance));
			}
		}
	}

	@Override
	public void removeFromInventory(Item item) {
		super.removeItemFromInventory(item);
	}

	@Override
	public void addToInventory(Item item) {
		super.addItemToInventory(item);
	}

	@Override
	public boolean isItemInInventory(Item item) {
		for (Item item1: this.getItemInventory()) {
			if (item == item1) {
				return true;
			}
		}
		return false;
	}
}
