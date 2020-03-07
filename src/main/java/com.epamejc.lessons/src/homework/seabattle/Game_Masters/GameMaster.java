package com.epamejc.lessons.src.homework.seabattle.Game_Masters;

import com.epamejc.lessons.src.homework.seabattle.Map.BattleMap;
import com.epamejc.lessons.src.homework.seabattle.Map.Cell;
import com.epamejc.lessons.src.homework.seabattle.Map.EventHandler;
import com.epamejc.lessons.src.homework.seabattle.Utils.InputUtils;
import com.epamejc.lessons.src.homework.seabattle.Utils.OutputUtils;

import java.io.IOException;

public class GameMaster {
    protected final EventHandler handler = new EventHandler();
    protected final InputUtils inputUtils;
    protected final OutputUtils outputUtils;
    protected BattleMap map1;
    protected BattleMap map2;

    public GameMaster(InputUtils inputUtils, OutputUtils outputUtils) {
        this.inputUtils = inputUtils;
        this.outputUtils = outputUtils;
    }

    protected boolean oneMove(BattleMap playerMap, BattleMap opponentMap) throws IOException {
        OutputUtils.printGameStateBeforeMove(playerMap, opponentMap, handler.getStringEvents());
        handler.clearEvents();
        return moveCycle(opponentMap);
    }

    protected boolean moveCycle(BattleMap opponentMap) throws IOException {
        boolean shoot = true;
        boolean hasShips = true;
        while (shoot && hasShips) {
            System.out.println("Введите клетку для удара:\n");
            Cell cell = inputUtils.getCell();
            if (opponentMap.isNotShootedCell(cell)) {
                shoot = opponentMap.shootByCell(cell);
            } else {
                System.out.println("Эта клетка уже известна. Выберите другую!");
                continue;
            }
            System.out.printf("%15s Карта соперника \n", "");
            OutputUtils.printMap(opponentMap.getMapWithoutShip());
            hasShips = opponentMap.haveAliveShips();
            OutputUtils.printShootResult(opponentMap, shoot, hasShips);
        }
        return hasShips;
    }
}
