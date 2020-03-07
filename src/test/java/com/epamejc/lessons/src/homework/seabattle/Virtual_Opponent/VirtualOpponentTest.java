package com.epamejc.lessons.src.homework.seabattle.Virtual_Opponent;

import com.epamejc.lessons.src.homework.seabattle.Map.BattleMap;
import com.epamejc.lessons.src.homework.seabattle.Map.Cell;
import com.epamejc.lessons.src.homework.seabattle.Map.EventHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class VirtualOpponentTest {
    @Test
    public void play1000Battles() {
        for (int i = 0; i < 1000; i++) {
            BattleMap map1 = new BattleMap("", new EventHandler());
            BattleMap map2 = new BattleMap("", new EventHandler());
            VirtualOpponent vo = new VirtualOpponent(map1);
            map2 = new RandomMapFiller(map2).fillMap();
            while (map2.haveAliveShips()) {
                Cell cell = vo.getNextShoot(0);
                if (map2.isNotShootedCell(cell)) {
                    int num = map2.getNumberAliveShips();
                    boolean shoot = map2.shootByCell(cell);
                    if (num != map2.getNumberAliveShips()) {
                        vo.updateAfterShoot(shoot, true);
                    } else {
                        vo.updateAfterShoot(shoot, false);
                    }
                }
            }
            assertFalse(map2.haveAliveShips());
            assertEquals(0, map2.getNumberAliveShips());
        }
    }

}