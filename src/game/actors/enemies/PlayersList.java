package game.actors.enemies;

import game.actors.Player;

import java.util.ArrayList;

public class PlayersList {

    private static PlayersList instance = null;
    private ArrayList<Player> players;

    private PlayersList() {
        this.players = new ArrayList<>();
    }

    public static PlayersList getInstance() {
        if (instance == null) {
            instance = new PlayersList();
        }
        return instance;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}
