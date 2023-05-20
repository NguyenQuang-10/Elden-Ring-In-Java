package game.environments;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;

public class GoldenFogDoor extends Ground {
    /**
     * the location interacting with this door will teleport the player to
     */
    private Location teleportTo;
    /**
     * the name of the direction
     */
    private String direction;

    /** Constructor
     *
     * @param teleportTo - the location interacting with this door will teleport the player to
     * @param direction - the name of the direction
     */
    public GoldenFogDoor(Location teleportTo, String direction) {
        super('D');
        this.teleportTo = teleportTo;
        this.direction = direction;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList allowedActions = new ActionList();
        if (location.map().isAnActorAt(location)) {
            allowedActions.add(new MoveActorAction(this.teleportTo, this.direction));
        }
        return allowedActions;
    }
}
