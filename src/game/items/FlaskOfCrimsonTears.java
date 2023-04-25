package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

import java.util.List;

public class FlaskOfCrimsonTears extends Item implements Consumable {
    private int usesLeft;


    /***
     * Constructor.
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", '8', false);
        usesLeft = 2;
    }


    public int getUsesLeft() {
        return this.usesLeft;
    }

    @Override
    public ConsumeAction getConsumeAction() {
        if (this.getUsesLeft() > 0) {
            return new ConsumeAction(this);
        }
        return  null;

    }

    @Override
    public void consumedBy(Actor actor) {
        this.usesLeft -= 1;
        actor.heal(250);
    }

    @Override
    public String getName() {
        return this.toString();
    }

    @Override
    public String getEffect() {
        return "Flask of Crimson Tear restored 250HP";
    }

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
