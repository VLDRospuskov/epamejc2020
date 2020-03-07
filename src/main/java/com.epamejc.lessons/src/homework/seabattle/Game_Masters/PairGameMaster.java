package com.epamejc.lessons.src.homework.seabattle.Game_Masters;

import com.epamejc.lessons.src.homework.seabattle.Map.BattleMap;
import com.epamejc.lessons.src.homework.seabattle.Utils.InputUtils;
import com.epamejc.lessons.src.homework.seabattle.Utils.OutputUtils;

import java.io.IOException;

public class PairGameMaster extends GameMaster {

    public PairGameMaster(InputUtils inputUtils, OutputUtils outputUtils) {
        super(inputUtils, outputUtils);
    }

    public void start() throws IOException {
        System.out.println("Первый игрок представтесь!");
        String name1 = inputUtils.getPlayerName();
        map1 = new BattleMap(name1, handler);
        System.out.println("Заполните поле кораблями");
        inputUtils.fillMapByInput(map1);
        System.out.println("Карта кораблей заполнена");
        outputUtils.nextPlayer();
        System.out.println("Второй игрок представтесь!");
        String name2 = inputUtils.getPlayerName();
        map2 = new BattleMap(name2, handler);
        System.out.println("Заполните поле кораблями");
        inputUtils.fillMapByInput(map2);
        System.out.println("Карта кораблей заполнена");
        outputUtils.nextPlayer();
        map1.setOpponent(name2);
        map2.setOpponent(name1);
        gameCycle();
    }

    private void gameCycle() throws IOException {
        while (true) {
            boolean player2HasShips = oneMove(map1, map2);
            if (!player2HasShips) {
                OutputUtils.endGame(map1.getOwner());
                break;
            }
            outputUtils.nextPlayer();
            boolean player1HasShips = oneMove(map2, map1);
            if (!player1HasShips) {
                OutputUtils.endGame(map2.getOwner());
                break;
            }
            outputUtils.nextPlayer();
        }
        OutputUtils.printHeaderForEndMap(map1.getOwner(), map2.getOwner());
        OutputUtils.print2Map(map1.getFullMap(), map2.getFullMap(), false);
    }
}
