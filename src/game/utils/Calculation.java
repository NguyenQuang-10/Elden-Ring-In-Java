package game.utils;

import edu.monash.fit2099.engine.positions.Location;

/**
 * A class used for calculations that are repeated in the game
 */
public class Calculation {

    /**
     * Calculates distance between 2 locations
     * @param a a location
     * @param b a location
     * @return distance between a and b
     */
    public static int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

    /**
     * Checks if location is in west side of game map
     * @param location the location
     * @return true if the location is in west else false
     */
    public static boolean isLocationWest(Location location){
        return location.x() < location.map().getXRange().max() / 2;
    }

    /**
     * Checks if location is in east side of game map
     * @param location the location
     * @return true if the location is in east else false
     */
    public static boolean isLocationEast(Location location){
        return location.x() >= location.map().getXRange().max() / 2;
    }
}
