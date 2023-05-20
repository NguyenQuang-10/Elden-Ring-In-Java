package game.utils;

import java.util.Arrays;
import java.util.List;

/**
 * A class that holds all the maps of the game accessible via static variables
 */
public class Maps {

    /**
     * Limgrave map
     */
    public static List<String> LIMGRAVE = Arrays.asList(
            "......................#.............#..........................+++.........",
            "......................#.............#.......................+++++..........",
            "......................#..___....____#.........................+++++........",
            "......................#...........__#............................++........",
            "......................#_____........#.............................+++......",
            "......................#............_#..............................+++.....",
            "......................######...######......................................",
            "...........................................................................",
            "...........................=...............................................",
            "........++++......................###___###................................",
            "........+++++++..................._____U__#................................",
            "..........+++.....................#________................................",
            "............+++...................#_______#................................",
            ".............+....................###___###................................",
            "............++......................#___#..................................",
            "..............+...................=........................................",
            "..............++.................................................=.........",
            "..............................................++...........................",
            "..................++++......................+++...............######..##...",
            "#####___######....++...........................+++............#....____....",
            "_____________#.....++++..........................+..............__.....#...",
            "_____________#.....+....++........................++.........._.....__.#...",
            "_____________#.........+..+.....................+++...........###..__###...",
            "_____________#.............++.............................................."
    );

    /**
     * Stormveil Castle map
     */
    public static List<String> STORMVEIL_CASTLE = Arrays.asList(
            "...........................................................................",
            "..................<...............<........................................",
            "...........................................................................",
            "##############################################...##########################",
            "............................#................#.......B..............B......",
            ".....B...............B......#................#.............................",
            "...............................<.........<.................................",
            ".....B...............B......#................#.......B..............B......",
            "............................#................#.............................",
            "#####################..#############...############.####..#########...#####",
            "...............#++++++++++++#................#++++++++++++#........___.....",
            "...............#++++++++++++...<.........<...#++++++++++++#........_U_.....",
            "...............#++++++++++++..................++++++++++++#........___.....",
            "...............#++++++++++++#................#++++++++++++#................",
            "#####...##########.....#############...#############..#############...#####",
            ".._______........................B......B........................B.....B...",
            "_____..._..____....&&........<..............<..............................",
            ".........____......&&......................................................",
            "...._______..................<..............<....................<.....<...",
            "#####....##...###..#####...##########___###############......##.....####...",
            "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
            "+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
            "+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
            "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++"
    );

    /**
     * Roundtable Hold map
     */
    public static List<String> ROUNDTABLE_HOLD = Arrays.asList(
            "##################",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "#_____________U__#",
            "#________________#",
            "########___#######"
    );

    /**
     * Boss room map
     */
    public static List<String> BOSS_ROOM = Arrays.asList(
            "+++++++++++++++++++++++++",
            ".........................",
            "..=......................",
            ".....................U...",
            ".........................",
            ".........................",
            ".........................",
            ".........................",
            "+++++++++++++++++++++++++"
    );
}