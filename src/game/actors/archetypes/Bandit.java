package game.actors.archetypes;
import game.weapons.GreatKnife;

/**
 * This class is associated with Bandit, and initialises the attributes of Bandit.
 * @author AppliedSession03Group03
 * @see Archetypes
 */
public class Bandit extends Archetypes{
    /**
     * A public constructor.
     */
    public Bandit(){
        super(414, new GreatKnife());
    }
}
