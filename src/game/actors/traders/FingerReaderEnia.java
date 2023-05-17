package game.actors.traders;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderactions.ExchangeWeaponAction;
import game.utils.Status;
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

        this.getSellableWeapons().add(new RemembranceOfTheGrafted());
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            for (WeaponItem weapon: otherActor.getWeaponInventory()) {
                if (weapon.hasCapability(Status.EXCHANGEABLE)) {
                    actions.add(new ExchangeWeaponAction(weapon, new AxeOfGodrick()));
                    actions.add(new ExchangeWeaponAction(weapon, new GraftedDragon()));
                    return actions;
                }
            }
        }

        return actions;
    }

}
