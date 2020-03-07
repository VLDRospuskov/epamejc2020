package com.epamejc.lessons.src.homework.seabattle.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EventHandlerTest {
    public EventHandler eventHandler;

    @Before
    public void createNewEventHandler() {
        eventHandler = new EventHandler();
    }

    @Test
    public void addHitEvent() {
        eventHandler.addHitEvent("Мария", "А1");
        String event = eventHandler.getStringEvents();
        assertTrue(event.contains("Игрок Мария попал по кораблю в клетке А1 ."));
    }

    @Test
    public void addMissEvent() {
        eventHandler.addMissEvent("Мария", "А1");
        String event = eventHandler.getStringEvents();
        assertTrue(event.contains("Игрок Мария промахнулся, клетка А1 пуста"));
    }

    @Test
    public void addShipDeadEvent() {
        eventHandler.addShipDeadEvent("Мария");
        String event = eventHandler.getStringEvents();
        assertTrue(event.contains("Корабль игрока Мария был уничтожен!"));
    }

    @Test
    public void clearEvents() {
        eventHandler.addShipDeadEvent("Мария");
        eventHandler.addShipDeadEvent("Павел");
        eventHandler.addMissEvent("Мария", "А1");
        eventHandler.clearEvents();
        String event = eventHandler.getStringEvents();
        assertTrue(event.isEmpty());
    }
}