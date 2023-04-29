package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAllAction;
import game.items.Purchaseable;
import game.items.Sellable;
/**
 * A curved sword, represented by ? (question mark), carried around by the Heavy Skeletal Swordsman that deals
 * 115 damage with 85% attack accuracy.
 * This sword allows the user to attack a single enemy within their surroundings or to perform a spinning attack,
 * which attacks all creatures, including the player, within the user’s surroundings. The damage dealt and the
 * attack accuracy for the targeted and the spinning attack is the same.
 * Note that since the spinning attack hits anything in the user’s surroundings, it may hit other actors of the
 * same type (Heavy Skeletal Swordsman A performing the spinning attack may accidentally hit Heavy Skeletal
 * Swordsman B)
 * If the user performs the spinning attack, actor A may get hit while actor B may not (the probability is
 * independent between each actor, i.e. one actor getting hit does not mean another actor will also get hit)
 * Edit: Grossmesser will be dropped by Heavy Skeletal Swordsman when they are defeated by the player
 * (after the pile of bones is destroyed).
 * Created by:
 * @author Ryan Nguyen
 */
public class Grossmesser extends WeaponItem implements Weapon, Sellable {


    /**
     * Constructor
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "slash", 85);
    }

    /** @see WeaponItem
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * This methods implements the spinning attack action that grossmesser has.
     * Created by:
     * @author Ryan Nguyen
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AttackAllAction(this);
    }

    /** @see Sellable
     *
     * @return the sell price of the item
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /** Instatiate a new instance of the weapon and return it
     * @see Sellable
     * @return new instance of the club
     */
    @Override
    public WeaponItem sellItem() {
        return new Grossmesser();
    }
}
