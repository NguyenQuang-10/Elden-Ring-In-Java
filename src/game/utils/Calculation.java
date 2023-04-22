package game.utils;

import edu.monash.fit2099.engine.positions.Location;

public class Calculation {
    public static int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
    public static boolean isLocationWest(Location location){
        return location.x() < location.map().getXRange().max() / 2;
    }

    public static boolean isLocationEast(Location location){
        return location.x() >= location.map().getXRange().max() / 2;
    }
}
