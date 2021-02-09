package com.test.buildteam;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class BuildTeamApplication {

    private final InputParser inputParser = new InputParser();
    private final PlayerClassifier playerClassifier = new PlayerClassifier();

    public static void main(String[] args) {
        try {
            BuildTeamApplication buildTeamApplication = new BuildTeamApplication();

            List<Player> players = buildTeamApplication.inputParser.parsePlayers();

            // 1. classify players as strikers, defenders, rejects and both striker and defenders
            buildTeamApplication.playerClassifier.populatePlayerType(players);

            // 2. redistribute both striker and defenders as either striker or defender
            List<Player> strikers = buildTeamApplication.getStrikers(players);
            List<Player> defenders = buildTeamApplication.getDefenders(players);
            List<Player> rejects = buildTeamApplication.getRejects(players);
            List<Player> both = buildTeamApplication.getBothStrikersAndDefenders(players);
            buildTeamApplication.redistributeBothStrikersAndDefenders(strikers, defenders, both);

            // 3. calculate team size
            int teamSizeHalf = Math.min(strikers.size(), defenders.size());

            // 4. sort the best players in strikers and defenders
            strikers.sort(Comparator.comparingInt(Player::getGoalsScored).reversed());
            defenders.sort(Comparator.comparingInt(Player::getGoalsDefended).reversed());

            // 5. form team and generate output
            List<String> output = buildTeamApplication.generateOutput(strikers, defenders, rejects, teamSizeHalf);
            for (String op : output) {
                System.out.println(op);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> generateOutput(List<Player> strikers, List<Player> defenders,
                                        List<Player> rejects,
                                        int teamSizeHalf) {
        List<String> output = new LinkedList<>();
        for (int i = 0; i < teamSizeHalf; i++) {
            output.add(strikers.get(i).getName() + " SELECT STRIKER");
            output.add(defenders.get(i).getName() + " SELECT DEFENDER");
        }
        for (Player reject : rejects) {
            output.add(reject.getName() + " REJECT NA");
        }
        for (int i = teamSizeHalf; i < strikers.size(); i++) {
            output.add(strikers.get(i).getName() + " REJECT NA");
        }
        for (int i = teamSizeHalf; i < defenders.size(); i++) {
            output.add(defenders.get(i).getName() + " REJECT NA");
        }
        output.sort(Comparator.comparing(str -> str.charAt(0)));
        return output;
    }

    private void redistributeBothStrikersAndDefenders(List<Player> strikers,
                                                      List<Player> defenders,
                                                      List<Player> both) {
        while (strikers.size() < defenders.size() && !both.isEmpty()) {
            strikers.add(both.remove(0));
        }
        while (defenders.size() < strikers.size() && !both.isEmpty()) {
            strikers.add(both.remove(0));
        }
    }

    private List<Player> getStrikers(List<Player> players) {
        return players.stream()
            .filter(player -> player.getPlayerType() == PlayerType.STRIKER)
            .collect(Collectors.toList());
    }

    private List<Player> getDefenders(List<Player> players) {
        return players.stream()
            .filter(player -> player.getPlayerType() == PlayerType.DEFENDER)
            .collect(Collectors.toList());
    }

    private List<Player> getRejects(List<Player> players) {
        return players.stream()
            .filter(player -> player.getPlayerType() == PlayerType.REJECT)
            .collect(Collectors.toList());
    }

    private List<Player> getBothStrikersAndDefenders(List<Player> players) {
        return players.stream()
            .filter(player -> player.getPlayerType() == PlayerType.BOTH)
            .collect(Collectors.toList());
    }

}
