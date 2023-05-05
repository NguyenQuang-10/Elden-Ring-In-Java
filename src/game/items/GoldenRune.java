package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

public class GoldenRune extends Item implements Consumable{

    private int usesLeft;

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

    }

    @Override
    public String getName() {
        return this.toString();
    }

    @Override
    public String getEffect() {
        return null;
    }
}
