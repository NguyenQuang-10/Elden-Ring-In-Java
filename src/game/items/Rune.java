package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.BuyerSellerList;
import game.reset.Resettable;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class Rune extends Item implements Resettable {

    private int value;
    private Location location;
    public Rune(int value) {
        super("Runes", '$', true);
        this.value = value;
        this.addCapability(Status.RUNE);
    }

    public Rune(int min, int max) {
        super("Runes", '$', true);
        this.value = RandomNumberGenerator.getRandomInt(min, max);
    }

    public int getValue() {
        return this.value;
    }

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

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String reset(Actor actor, GameMap map) {
        this.location.removeItem(this);
        return this + " value: " + this.getValue() + " is dropped";
    }
}
