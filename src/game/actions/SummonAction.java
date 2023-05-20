package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Ally;
import game.actors.Invader;
import game.actors.archetypes.Archetypes;
import game.utils.ArchetypeManager;
import java.util.Random;

/**
 * An action that allows an actor to summon Ally or Invader when in close proximity to the summon sign.
 * @author AppliedSession03Group03
 * @see Action
 */
public class SummonAction extends Action {
    /**
     * Method to summon the Ally/Invader near the summon sign and give it a random archetype.
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return      A string description of what action has occurred.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // Finding the location of the summon sign.
        // This method is called when the summon sign is in reach of the player.
        Location location = map.locationOf(actor);
        Location summonSignLocation = map.locationOf(actor); // Initialise summon sign location to where the actor is at.
        for(Exit exit: location.getExits()) {
            Location destination = exit.getDestination();
            if (destination.getDisplayChar()=='=') {
                summonSignLocation = destination;
            }
        }

        // Look for space around the summon sign to summon ally or invader (50% chance either one).
        for(Exit exit: summonSignLocation.getExits()) {
            Location summonLocation = exit.getDestination();
            if (!summonLocation.containsAnActor()){
                if (new Random().nextInt(100) < 50){
                    ArchetypeManager allyManager = new ArchetypeManager();
                    Archetypes allyArchetype = allyManager.randomArchetype();
                    Ally ally = new Ally(allyArchetype.getHP(), allyArchetype.getWeapon());
                    map.addActor(ally, summonLocation);
                    return actor + " summoned an " + ally;
                }
                else {
                    ArchetypeManager invaderManager = new ArchetypeManager();
                    Archetypes invaderArchetype = invaderManager.randomArchetype();
                    Invader invader = new Invader(invaderArchetype.getHP(), invaderArchetype.getWeapon());
                    map.addActor(invader, summonLocation);
                    return actor + " summoned an " + invader;
                }
            }
        }
        // Need to determine what to say if no spaces available.
        return actor + " tried to summon, but failed!";
    }

    /**
     * Description of the actor summoning.
     * @param actor The actor performing the action.
     * @return      A string description of the summoning.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons a guest from another realm.";
    }
}
