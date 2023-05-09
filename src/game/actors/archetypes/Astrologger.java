package game.actors.archetypes;
import game.weapons.Club;

public class Astrologger extends Archetypes{
    /**
     * A public constructor.
     */
    public Astrologger() {
        super(396, new Club());
    }
    // Make sure Astrologger has a weapon that is not the Astrologger's Staff because the staff's implementation is
    // optional. Note this change in the design rationale.

}
