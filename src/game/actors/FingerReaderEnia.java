package game.actors;

import game.weapons.*;

public class FingerReaderEnia extends Trader {
    /**
     * Constructor.
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E');

        this.getSellableWeapons().add(new Club());
        this.getSellableWeapons().add(new GreatKnife());
        this.getSellableWeapons().add(new Uchigatana());
        this.getSellableWeapons().add(new Scimitar());
        this.getSellableWeapons().add(new Grossmesser());
    }

}
