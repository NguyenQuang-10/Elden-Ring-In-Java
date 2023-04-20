package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import game.actors.BuyerSellerList;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class Rune extends Item {

    private int value;
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
}
