package Homeworks.HW6.SeaBattle.Game;

public enum GameMode {
    PVE("Single player mode"),
    PVP("Multiplayer mode");

    private static GameMode[] gameModes = GameMode.values();

    private String description;

    GameMode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
