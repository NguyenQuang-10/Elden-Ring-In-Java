package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.Reviver;

public class ReviveAction extends Action {
    private Actor toRevive;

    public ReviveAction(Reviver reviver) {
        this.toRevive = reviver.getSpawner();
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        map.removeActor(actor);
        this.toRevive.heal(Integer.MAX_VALUE);
        here.addActor(this.toRevive);
        return this.toRevive + " has been revived from " + actor;
    }

    @Override
    public String menuDescription(Actor actor) {
        return this.toRevive + " has been revived ";
    }
}
