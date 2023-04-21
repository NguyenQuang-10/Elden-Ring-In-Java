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
public class ArchetypeManager {
    // Dictionary with the archetypes.
    private final Dictionary<String,ArrayList<Object>> archetypes = this.setArchetypes();

    // Create method that creates the new player.
    public Player createPlayer(){
        // Sets a dictionary of the player.
        String keyArchetype = selectArchetype();
        ArrayList<Object> archetypeAttributes = this.archetypes.get(keyArchetype);
        Player player = new Player("Tarnished", '@', (Integer) archetypeAttributes.get(0));
        player.addWeaponToInventory((WeaponItem) archetypeAttributes.get(1));
        return player;
    }

    // Create class the ask for the user input.
    public String selectArchetype(){
        Display display = new Display();
        // Print the menu with the archetype selection board.
        display.println("Archetypes Available:");
        for (Enumeration<String> aEnum = this.archetypes.keys(); aEnum.hasMoreElements();){
            display.println(aEnum.nextElement());
        }

        // Ask for the user input and verify the input.
        String chosenArchetype;
        Scanner scanner = new Scanner(System.in);
        boolean statusOfInput = true;
        String keyOfChosenArchetype = "";
        while(statusOfInput){
            try{
                display.println("Enter your chosen archetype [e.g. Write 'Bandit' and click enter]: ");
                chosenArchetype = scanner.nextLine();
                for (Enumeration<String> aEnum = this.archetypes.keys(); aEnum.hasMoreElements();){
                    String nextElement = aEnum.nextElement();
                    if (nextElement.equals(chosenArchetype)){
                        keyOfChosenArchetype = nextElement;
                    }
                }
                if (keyOfChosenArchetype.equals("")){
                    display.println("Invalid archetype, please try again!");
                }
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

    public Dictionary<String, ArrayList<Object>> setArchetypes(){
        Dictionary<String,ArrayList<Object>> myArchetypes = new Hashtable<String, ArrayList<Object>>();
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add(455);
        myList.add(new Uchigatana());
        myArchetypes.put("Samurai", (ArrayList<Object>) myList.clone());
        myList.clear();
        myList.add(414);
        myList.add(new GreatKnife());
        myArchetypes.put("Bandit", (ArrayList<Object>) myList.clone());
        myList.clear();
        myList.add(414);
        myList.add(new Club());
        myArchetypes.put("Wretch", (ArrayList<Object>) myList.clone());
        return myArchetypes;
    }
}