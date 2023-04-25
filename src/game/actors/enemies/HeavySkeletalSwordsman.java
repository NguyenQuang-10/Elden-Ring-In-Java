package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SpawnAction;
import game.behaviours.*;
import game.items.Rune;
import game.weapons.Grossmesser;

public class HeavySkeletalSwordsman extends Enemy {

    /**
     * A public constructor
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153, EnemyType.SKELETON);
        this.addRune(35, 892);
        this.addWeaponToInventory(new Grossmesser());
        this.addBehaviour(2, new SpawnBehaviour(new PileOfBones(this)));
        this.addBehaviour(3, new DespawnBehaviour(10));
        this.addBehaviour(4, new AttackBehaviour(false));
        this.addBehaviour(99, new WanderBehaviour());
    }




    /**
     * Returns the default attack capability of HeavySkeletalSwordsman without a weapon
     * @return an IntrinsicWeapon
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return super.allowableActions(otherActor, direction, map);
    }
}
