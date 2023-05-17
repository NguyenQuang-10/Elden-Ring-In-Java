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

public class GodrickSoldier extends Enemy {
    /**
     * A public constructor
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198, EnemyType.STORMVEIL, false);
        this.addRune(38, 70);
    }



}
