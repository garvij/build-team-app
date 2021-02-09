package com.buildteam;

public class Player {

    private String name;
    private double height;
    private double bmi;
    private int goalsScored;
    private int goalsDefended;
    private PlayerType playerType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsDefended() {
        return goalsDefended;
    }

    public void setGoalsDefended(int goalsDefended) {
        this.goalsDefended = goalsDefended;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    @Override
    public String toString() {
        return "Player{" +
            "name='" + name + '\'' +
            ", height=" + height +
            ", bmi=" + bmi +
            ", goalsScored=" + goalsScored +
            ", goalsDefended=" + goalsDefended +
            ", playerType=" + playerType +
            '}';
    }
}
