package game.utils;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;
import game.actors.Player;
import java.util.*;
import java.util.ArrayList;
import edu.monash.fit2099.engine.displays.Display;
import java.util.Scanner;

/**
 * A class that asks for the users to select the archetype and creates the player according to the archetype selected. This
 * class is implemented in the Application class to create an instance of a Player for the game.
 * Created By:
 * @author Ryan Nguyen
 * @version JDK 20
 * @see game.Application
 */
public class ArchetypeManager {
    /**
     * A dictionary with the archetypes, each archetype has the name as the key and an array containing the archetype's
     * hit points and weapon.
     */
    private final Dictionary<String,ArrayList<Object>> archetypes = this.setArchetypes();

    /**
     * Method to create a new player, which calls the selectArchetype() method to set an archetype.
     * @return Player
     */
    public Player createPlayer(){
        String keyArchetype = selectArchetype();    // Get the archetype from the user.
        ArrayList<Object> archetypeAttributes = this.archetypes.get(keyArchetype);  // Get the attributes of the corresponding archetype.
        Player player = new Player("Tarnished", '@', (Integer) archetypeAttributes.get(0)); // Set the player.
        player.addWeaponToInventory((WeaponItem) archetypeAttributes.get(1));   // Add the archetype's weapon to the player's inventory.
        return player;
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
     * archetypes to the game.
     * @return The dictionary with the archetypes.
     */
    public Dictionary<String, ArrayList<Object>> setArchetypes(){
        // Initialise a dictionary using Hashtable.
        Dictionary<String,ArrayList<Object>> myArchetypes = new Hashtable<String, ArrayList<Object>>();
        ArrayList<Object> myList = new ArrayList<Object>();

        // Add Samurai archetype.
        myList.add(455);
        myList.add(new Uchigatana());
        myArchetypes.put("s", (ArrayList<Object>) myList.clone());

        // Add Bandit archetype.
        myList.clear();
        myList.add(414);
        myList.add(new GreatKnife());
        myArchetypes.put("b", (ArrayList<Object>) myList.clone());

        // Add Wretch archetype.
        myList.clear();
        myList.add(414);
        myList.add(new Club());
        myArchetypes.put("w", (ArrayList<Object>) myList.clone());

        // Return the dictionary of archetype, to be initialised as an attribute of this class.
        return myArchetypes;
    }
}