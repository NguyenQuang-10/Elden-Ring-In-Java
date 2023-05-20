package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.*;
import game.utils.Status;
import game.weapons.HeavyCrossbow;

import java.util.ArrayList;

/**
 * The soldier of Godrick, represented by p,
 * that has 198 hit points and carries around a ranged weapon,
 * The Heavy Crossbow will be dropped by the soldier of Godrick when they are defeated by the player.
 * @author AppliedSession03Group03
 */
public class GodrickSoldier extends Enemy {
    /**
     * A public constructor
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198, EnemyType.STORMVEIL_SOILDER, false);
        this.addRune(38, 70);
        this.addWeaponToInventory(new HeavyCrossbow());
        this.clearBehaviour();

        this.setBehaviour(0, new WeaponEffectBehaviour());

        AttackBehaviour atkBeh = new AttackBehaviour(false);
        atkBeh.addToFriendlyType(EnemyType.STORMVEIL_DOG);
        this.setBehaviour(1, atkBeh);

        // behaviour at key 2 is reserved for follow behaviour

        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new DespawnBehaviour(10));
        behaviours.add(new WanderBehaviour());

        for (int i = 0; i < behaviours.size(); i++) {
            this.setBehaviour(i+3, behaviours.get(i));
        }
    }



}
