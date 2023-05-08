package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

import java.util.List;

/**
 *  The Flask of Crimson Tears. This item can be consumed twice (maximum uses for now), and each time the player uses
 *  it, their health will be restored by 250 points. Additionally, the player cannot drop Flask of Crimson Tears.
 *  @author AppliedSession03Group03
 */
public class FlaskOfCrimsonTears extends Item implements Consumable {
    /**
     * The uses the play have left
     */
    private int usesLeft;


    /***
     * Constructor.
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", '8', false);
        usesLeft = 2;
    }

    /**
     * @return return the number of uses left
     * @see Consumable
     */
    public int getUsesLeft() {
        return this.usesLeft;
    }

    /**
     * @return return the consume action for this item
     * @see Consumable
     */
    @Override
    public ConsumeAction getConsumeAction() {
        if (this.getUsesLeft() > 0) {
            return new ConsumeAction(this);
        }
        return  null;

    }

    /**
     * use this item on an actor
     * @see Consumable
     */
    @Override
    public void consumedBy(Actor actor) {
        this.usesLeft -= 1;
        actor.heal(250);
    }


    /**
     * @return get the effect of the item
     * @see Consumable
     */
    @Override
    public String getEffect() {
        return "Flask of Crimson Tear restored 250HP";
    }

    /**
     * @return the action list that could be act upon this item
     * @see Item
     */
    @Override
    public List<Action> getAllowableActions() {
        ActionList allowableActions = new ActionList();
        if (usesLeft > 0) {
            allowableActions.add(this.getConsumeAction());
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
