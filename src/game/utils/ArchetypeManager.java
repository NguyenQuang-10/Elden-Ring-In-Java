package game.utils;
import game.actors.archetypes.*;
import game.actors.Player;
import java.util.*;
import edu.monash.fit2099.engine.displays.Display;
import java.util.Scanner;

/**
 * A class that asks for the users to select the archetype and creates the player according to the archetype selected. This
 * class is implemented in the Application class to create an instance of a Player for the game.
 * Created By:
 * @author AppliedSession03Group03
 * @see game.Application
 */
public class ArchetypeManager {
    /**
     * A dictionary with the archetypes, each archetype has the name as the key and an associated archetype.
     */
    private final Dictionary<String,Archetypes> archetypes = this.setArchetypes();

    /**
     * Method to create a new player, which calls the selectArchetype() method to set an archetype.
     * @return Player
     */
    public Player createPlayer(){
        String keyArchetype = selectArchetype();    // Get the archetype from the user.
        Archetypes selectedArchetype = this.archetypes.get(keyArchetype);  // Get the attributes of the corresponding archetype.
        return new Player("Tarnished", '@', selectedArchetype);
    }

    /**
     * Method to ask user to select an archetype, and ensure that the input is valid.
     * @return The chosen archetype by the user.
     */
    public String selectArchetype(){
        Display display = new Display();

        // Ask for the user input and verify the input.
        String chosenArchetype;
        Scanner scanner = new Scanner(System.in);
        boolean statusOfInput = true;
        String keyOfChosenArchetype = "";
        while(statusOfInput){
            try{
                // Print the menu with the archetype selection board.
                display.println("Select your role: ");
                display.println("b: Bandit");
                display.println("s: Samurai");
                display.println("w: Wretch");
                display.println("a: Astrologger");
                chosenArchetype = scanner.nextLine();   // chosenArchetype is a single letter.
                // Loop to match the chosenArchetype to the archetype in the dictionary.
                for (Enumeration<String> aEnum = this.archetypes.keys(); aEnum.hasMoreElements();){
                    String nextElement = aEnum.nextElement();
                    if (nextElement.equals(chosenArchetype)){
                        keyOfChosenArchetype = nextElement; // Set the key of the archetype to be returned.
                    }
                }
                // Case for when nothing is typed.
                if (keyOfChosenArchetype.equals("")){
                    display.println("Invalid archetype, please try again!");
                }
                // If we successfully found a key then this statement executes loop exit.
                else{
                    statusOfInput = false;
                }

            } catch(IllegalArgumentException e){
                display.println("Invalid archetype, please try again!");
            }
        }

        // Return the key of the chosen archetype.
        return keyOfChosenArchetype;
    }

    /**
     * Method to set the dictionary to the have the archetypes available, modify this function if you want to add more
     * archetypes to the game that the player can select from.
     * @return The dictionary with the archetypes.
     */
    public Dictionary<String, Archetypes> setArchetypes(){
        // Initialise a dictionary using Hashtable.
        Dictionary<String, Archetypes> myArchetypes = new Hashtable<String, Archetypes>();

        // Add the archetypes into the dictionary.
        myArchetypes.put("s", new Samurai());
        myArchetypes.put("b", new Bandit());
        myArchetypes.put("w", new Wretch());
        myArchetypes.put("a", new Astrologer());

        // Return the dictionary of archetype, to be initialised as an attribute of this class.
        return myArchetypes;
    }

    public Archetypes randomArchetype(){
        Dictionary<String,Archetypes> dictOfArchetypes = this.archetypes;

        int randomIndex = new Random().nextInt(dictOfArchetypes.size());
        int currentIndex = 0;
        Archetypes randomArchetype = null;
        for (Enumeration<String> aEnum = dictOfArchetypes.keys(); aEnum.hasMoreElements();){
            String nextElement = aEnum.nextElement();
            if (currentIndex == randomIndex){
                randomArchetype = dictOfArchetypes.get(nextElement);
            }
            else {
                currentIndex++;
            }
        }
        return randomArchetype;
    }

    public Dictionary<String,Archetypes> getArchetypes(){
        return this.archetypes;
    }
}