package game.actors.archetypes;
import game.weapons.Uchigatana;

/**
 * This class is associated with Samurai, and initialises the attributes of Samurai.
 */
public class Samurai extends Archetypes {
    /**
     * A public constructor.
     */
    public Samurai(){
        super(455, new Uchigatana());
    }
}
