package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.actions.traderactions.BuySellCapable;
import game.actors.BuyerSellerList;

import java.util.List;

public class GoldenRune extends Item implements Consumable{

    private int usesLeft;

    private int runeValue;

    /***
     * Constructor.
     */
    public GoldenRune() {
        super("Golden Rune", '*', true);
        usesLeft = 1;
    }

    @Override
    public int getUsesLeft() {
        return this.usesLeft;
    }

    @Override
    public ConsumeAction getConsumeAction() {
        if (this.getUsesLeft() == 1)
            return new ConsumeAction(this);
        return null;
    }

    @Override
    public void consumedBy(Actor actor) {
        this.usesLeft -= 1;
        BuySellCapable player = BuyerSellerList.getInstance().getBuyerSeller(actor);
        Rune rune = new Rune(200, 10000);
        player.addRune(rune);
        this.runeValue = rune.getValue();
    }

    @Override
    public String getEffect() {
        return "Golden Rune generated Rune of value: " + this.runeValue;
    }

    @Override
    public List<Action> getAllowableActions() {
        ActionList allowableActions = new ActionList();
        if (this.usesLeft == 1) {
            allowableActions.add(this.getConsumeAction());
        }

        return allowableActions.getUnmodifiableActionList();
    }
}
