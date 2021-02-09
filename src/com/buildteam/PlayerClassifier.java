package com.buildteam;

import java.util.List;

public class PlayerClassifier {

    public static final double MIN_HEIGHT = 5.8;
    public static final double MAX_BMI = 23;
    public static final int MIN_GOALS_SCORED = 50;
    public static final int MIN_GOALS_DEFENDED = 30;

    void populatePlayerType(List<Player> players) {
        players.forEach(player -> {
            if (player.getHeight() <= MIN_HEIGHT && player.getBmi() >= MAX_BMI) {
                player.setPlayerType(PlayerType.REJECT);
            } else if (player.getGoalsScored() >= MIN_GOALS_SCORED &&
                player.getGoalsDefended() >= MIN_GOALS_DEFENDED) {
                player.setPlayerType(PlayerType.BOTH);
            } else if (player.getGoalsScored() >= MIN_GOALS_SCORED) {
                player.setPlayerType(PlayerType.STRIKER);
            } else if (player.getGoalsDefended() >= MIN_GOALS_DEFENDED) {
                player.setPlayerType(PlayerType.DEFENDER);
            } else {
                player.setPlayerType(PlayerType.REJECT);
            }
        });
    }

}
