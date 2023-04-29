package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PickUpRuneAction;
import game.actors.BuyerSellerList;
import game.reset.ResetManager;
import game.reset.Resettable;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * Rune is the currency used by Player for purchases
 * @author AppliedSession03Gropu03
 */
public class Rune extends Item implements Resettable {

    /**
     * The value of the Rune
     */
    private int value;

    /**
     * The location of the Rune if the Rune is on the ground
     */
    private Location location;

    /**
     * A public constructor
     * @param value The value of the Rune
     */
    public Rune(int value) {
        super("Runes", '$', true);
        this.value = value;
        this.addCapability(Status.RUNE);
    }

    /**
     * A public constructor used to add Runes to enemies
     * @param min minimum value of the Rune
     * @param max maximum value of the Rune
     */
    public Rune(int min, int max) {
        super("Runes", '$', true);
        this.value = RandomNumberGenerator.getRandomInt(min, max);
        this.addCapability(Status.RUNE);
    }

    /**
     * Getter for value
     * @return value of the Rune
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Adds Rune to Player if the Player killed enemy and enemy drop the Rune
     * Drops the Rune to ground if enemy killed by enemy
     * @param actor the Actor performing the kill
     * @return DropItemAction if enemy kill enemy else Rune directly added to Player Rune inventory
     */
    @Override
    public DropAction getDropAction(Actor actor) {
        BuyerSellerList buyerSellerList = BuyerSellerList.getInstance();
        if (buyerSellerList.isBuyerSeller(actor)) {
            buyerSellerList.getBuyerSeller(actor).addRune(this);
            return null;
        } else if (portable) {
            return new DropItemAction(this);
        }
        return null;
    }

    /**
     * Allows the Player to pick up Rune from ground and add to their Rune inventory
     * @param actor The Actor next to the Rune
     * @return PickUpAction if it is Player else null
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        BuyerSellerList buyerSellerList = BuyerSellerList.getInstance();
        if (buyerSellerList.isBuyerSeller(actor)) {
            return new PickUpRuneAction(this, buyerSellerList.getBuyerSeller(actor));
        }
        return null;
    }

    /**
     * Setter for location
     * @param location the location of the Rune
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Removes Rune on ground from map if Player dies
     * @param actor The player that triggered game reset
     * @param map The current gameMap
     * @return a string representing what happen to reset the Rune
     */
    @Override
    public String reset(Actor actor, GameMap map) {
        System.out.println(actor);
        if (!actor.isConscious()) {
            System.out.println("Printing rune location");
            System.out.println(this.location.getItems().size());
            this.location.removeItem(this);

            ResetManager.getInstance().removeResettable(this);
            return this + " value: " + this.getValue() + " is dropped";
        } else {
            System.out.println("I ain't resetting bitch");
            return "";
        }
    }
}
