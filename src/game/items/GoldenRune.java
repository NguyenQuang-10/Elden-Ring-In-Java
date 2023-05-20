package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.actions.traderactions.BuySellCapable;
import game.actors.BuyerSellerList;

import java.util.List;

/**
 * An item, represented by *, that cannot be purchased. Instead, this item can be found scattered across the maps.
 * Therefore, it can be picked up or dropped off by the player.
 *
 * It can be consumed. When consumed, this item can generate any amount of runes, ranging from 200-10000 runes.
 * @author AppliedSession03Group03
 */
public class GoldenRune extends Item implements Consumable{

    /**
     * The number of uses left
     */
    private int usesLeft;

    /**
     * The value of Rune to be generated
     */
    private int runeValue;

    /***
     * A public Constructor
     */
    public GoldenRune() {
        super("Golden Rune", '*', true);
        usesLeft = 1;
    }

    /**
     * Getter for usesLeft
     * @return The number of uses left
     */
    @Override
    public int getUsesLeft() {
        return this.usesLeft;
    }

    /**
     * Return ConsumeAction to consume this item if the number of usesLeft is == 1
     * @return ConsumeAction
     */
    @Override
    public ConsumeAction getConsumeAction() {
        if (this.getUsesLeft() == 1)
            return new ConsumeAction(this);
        return null;
    }

    /**
     * Use this item on an actor
     * @see Consumable
     */
    @Override
    public void consumedBy(Actor actor) {
        this.usesLeft -= 1;
        BuySellCapable player = BuyerSellerList.getInstance().getBuyerSeller(actor);
        Rune rune = new Rune(200, 10000);
        player.addRune(rune);
        this.runeValue = rune.getValue();
    }

    /**
     * Returns a string representing the effect of the item
     * @return get the effect of the item
     * @see Consumable
     */
    @Override
    public String getEffect() {
        return "Golden Rune generated Rune of value: " + this.runeValue;
    }

    /**
     * Returns the action list that could be act upon this item
     * @return the action list that could be act upon this item
     * @see Item
     */
    @Override
    public List<Action> getAllowableActions() {
        ActionList allowableActions = new ActionList();
        if (this.usesLeft == 1) {
            allowableActions.add(this.getConsumeAction());
        }

        return allowableActions.getUnmodifiableActionList();
    }
}
