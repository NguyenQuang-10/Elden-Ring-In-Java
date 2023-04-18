package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.utils.RandomNumberGenerator;

public class Rune extends Item {

    private int value;
    public Rune(int value) {
        super("Runes", '$', true);
        this.value = value;
    }

    public Rune(int min, int max) {
        super("Runes", '$', true);
        this.value = RandomNumberGenerator.getRandomInt(min, max);
    }
}
