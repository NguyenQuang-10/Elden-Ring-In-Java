package game.actors.archetypes;
import game.weapons.Club;

/**
 * This class is associated with Wretch, and initialises the attributes of Wretches.
 */
public class Wretch extends Archetypes{
    /**
     * A public constructor.
     */
    public Wretch(){
        super(414, new Club());
    }
}
