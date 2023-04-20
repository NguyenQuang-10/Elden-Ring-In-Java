package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
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
    public void tick(Location currentLocation, Actor actor) {
    }

    @Override
    public void tick(Location currentLocation) {
    }

    @Override
    public DropAction getDropAction(Actor actor) {
        if(portable)
            return new DropItemAction(this);
        return null;
    }
}
