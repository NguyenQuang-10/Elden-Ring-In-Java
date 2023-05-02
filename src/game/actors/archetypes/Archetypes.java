package game.actors.archetypes;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * This class is an abstract class acting as template for which we can extend from and create archetypes (this will be
 * particularly useful for future assignments).
 * @author Ryan Nguyen
 * @version JDK 20
 */
public abstract class Archetypes {
    /**
     * The archetypes hit point.
     */
    private int hitPoints;

    /**
     * The weapon associated with selecting the archetype.
     */
    private WeaponItem weapons;

    /**
     * A public constructor.
     * @param hitPoints The archetype's hit points.
     * @param weapons   The archetype's weapon.
     */
    public Archetypes(int hitPoints, WeaponItem weapons){
        this.hitPoints = hitPoints;
        this.weapons = weapons;
    }

    /**
     * Getter to get the hit points of the archetype.
     * @return The archetype's hit points.
     */
    public int getHP() {
        return this.hitPoints;
    }

    /**
     * Getter to get the weapon of the archetype.
     * @return The archetype's weapon.
     */
    public WeaponItem getWeapon(){
        return this.weapons;
    }


}
