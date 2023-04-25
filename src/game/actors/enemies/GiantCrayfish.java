package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.*;

public class GiantCrayfish extends Enemy {

    /**
     * A public constructor
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803, EnemyType.SEAANIMAL);
        this.addRune(500, 2374);
        this.addBehaviour(2, new DespawnBehaviour(10));
        this.addBehaviour(3, new AttackBehaviour(true));
        this.addBehaviour(99, new WanderBehaviour());
    }



    /**
     * Returns the default attack capability of GiantCrayfish without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }
}
