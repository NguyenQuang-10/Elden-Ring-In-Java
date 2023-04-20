package game.items;

import edu.monash.fit2099.engine.items.Item;
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
}
