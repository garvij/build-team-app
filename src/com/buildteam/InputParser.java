package com.buildteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class InputParser {

    public List<Player> parsePlayers() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = reader.readLine();
        int rows = Integer.parseInt(line1);
        String line2 = reader.readLine();
        int cols = Integer.parseInt(line2);
        List<Player> players = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            String playerStr = reader.readLine();
            players.add(getPlayer(playerStr));
        }
        return players;
    }

    private Player getPlayer(String str) {
        Player player = new Player();
        String[] playerVals = str.split("\\s+");
        player.setName(playerVals[0]);
        player.setHeight(Double.parseDouble(playerVals[1]));
        player.setBmi(Double.parseDouble(playerVals[2]));
        player.setGoalsScored(Integer.parseInt(playerVals[3]));
        player.setGoalsDefended(Integer.parseInt(playerVals[4]));
        return player;
    }


}
