package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import game.actions.FlaskConsumeAction;

import java.util.List;

public class FlaskOfCrimsonTears extends Item {
    private int usesLeft;


    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", '8', false);
        usesLeft = 2;
    }

    /**
     * Reduce the number of usesLeft by 1 if any use is left
     */
    public void used() {
        if (this.usesLeft > 0) {
            this.usesLeft -= 1;
        }
    }

    public int getUsesLeft() {
        return this.usesLeft;
    }

    @Override
    public List<Action> getAllowableActions() {
        ActionList allowableActions = new ActionList();
        if (usesLeft > 0) {
            allowableActions.add(new FlaskConsumeAction(this));
        }

        return allowableActions.getUnmodifiableActionList();
    }




    /** Cannot drop flask of crimson tear
     *
     * @param actor the actor holding the flask
     * @return null
     */
    public DropAction getDropAction(Actor actor) {
        return null;
    }

}
