package com.epamejc.lessons.src.homework.seabattle.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventHandler {
    private final String HIT = "Игрок %s попал по кораблю в клетке %s .";
    private final String SHIP_DEAD = "Корабль игрока %s был уничтожен!";
    private final String MISS = "Игрок %s промахнулся, клетка %s пуста!";
    private final List<String> events = new ArrayList<>();

    public void addHitEvent(String gamer, String cellLocation) {
        events.add(String.format(HIT, gamer, cellLocation));
    }

    public void addMissEvent(String gamer, String cellLocation) {
        events.add(String.format(MISS, gamer, cellLocation));
    }

    public void addShipDeadEvent(String gamer) {
        events.add(String.format(SHIP_DEAD, gamer));
    }

    public String getStringEvents() {
        return events.stream().map(event -> event + "\n").collect(Collectors.joining());
    }

    public void clearEvents() {
        events.clear();
    }
}
