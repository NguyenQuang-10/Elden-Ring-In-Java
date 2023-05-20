package game.actors.traders;

import game.utils.Status;
import game.weapons.*;

/**
 * Trader that could be found on the first map is Merchant Kale,
 * represented by K (uppercase K). Merchant Kale sits around the building in the middle of the map
 * Merchant Kale allows the player to purchase weapons
 * @author AppliedSession03Group03
 */
public class  MerchantKale extends Trader {

    /**
     * A public constructor
     */
    public MerchantKale() {
        super("Merchant Kale", 'K');
        super.addCapability(Status.TRADER);
        this.getPurchaseableWeapons().add(new Club());
        this.getPurchaseableWeapons().add(new GreatKnife());
        this.getPurchaseableWeapons().add(new Uchigatana());
        this.getPurchaseableWeapons().add(new Scimitar());
        this.getPurchaseableWeapons().add(new ConcussionStaff());
        this.getPurchaseableWeapons().add(new Bomb());
        this.getPurchaseableWeapons().add(new PoisonedAxe());

        this.getSellableWeapons().add(new Club());
        this.getSellableWeapons().add(new GreatKnife());
        this.getSellableWeapons().add(new Uchigatana());
        this.getSellableWeapons().add(new Scimitar());
        this.getSellableWeapons().add(new Grossmesser());
    }
}
