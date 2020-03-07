package com.epamejc.lessons.src.homework.seabattle.Virtual_Opponent;

import com.epamejc.lessons.src.homework.seabattle.Map.BattleMap;
import com.epamejc.lessons.src.homework.seabattle.Map.EventHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomMapFillerTest {

    @Test
    public void fillMap() {
        BattleMap map = new BattleMap("", new EventHandler());
        map = new RandomMapFiller(map).fillMap();
        assertEquals(10, map.getNumberAliveShips());
    }
}