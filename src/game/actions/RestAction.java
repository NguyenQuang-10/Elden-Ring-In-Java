package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class RestAction extends Action {

    private String ground;
    private String direction;
    private Location destination;

    public RestAction(String ground, Location destination, String direction) {
        this.ground = ground;
        this.direction = direction;
        this.destination = destination;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return (new ResetAction(false)).execute(actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at " + this.ground;
    }
}
