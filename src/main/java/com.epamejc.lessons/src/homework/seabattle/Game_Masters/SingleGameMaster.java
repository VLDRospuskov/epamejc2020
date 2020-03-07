package com.epamejc.lessons.src.homework.seabattle.Game_Masters;

import com.epamejc.lessons.src.homework.seabattle.Map.BattleMap;
import com.epamejc.lessons.src.homework.seabattle.Map.Cell;
import com.epamejc.lessons.src.homework.seabattle.Utils.InputUtils;
import com.epamejc.lessons.src.homework.seabattle.Utils.OutputUtils;
import com.epamejc.lessons.src.homework.seabattle.Virtual_Opponent.VirtualOpponent;

import java.io.IOException;

public class SingleGameMaster extends GameMaster {
    private final VirtualOpponent opponent;

    public SingleGameMaster(InputUtils inputUtils, OutputUtils outputUtils) {
        super(inputUtils, outputUtils);
        map2 = new BattleMap("Джарвис", handler);
        opponent = new VirtualOpponent(map2);
    }

    public void start() throws IOException {
        System.out.println("Игрок представтесь!");
        String name = inputUtils.getPlayerName();
        map1 = new BattleMap(name, handler);
        System.out.println("Заполните поле кораблями");
        inputUtils.fillMapByInput(map1);
        System.out.println("Карта кораблей заполнена");
        map1.setOpponent(map2.getOwner());
        map2.setOpponent(name);
        System.out.println("Против вас играет :" + map2.getOwner());
        gameCycle();
    }

    private void gameCycle() throws IOException {
        while (true) {
            boolean player2HasShips = oneMove(map1, map2);
            if (!player2HasShips) {
                OutputUtils.endGame(map1.getOwner());
                break;
            }
            outputUtils.nextVirtualPlayer();
            System.out.println("\nХод переходит игроку: " + map2.getOwner() + "\n");
            boolean player1HasShips = oneVirtualOpponentMove();
            if (!player1HasShips) {
                OutputUtils.endGame(map2.getOwner());
                break;
            }
        }
        OutputUtils.printHeaderForEndMap(map1.getOwner(), map2.getOwner());
        OutputUtils.print2Map(map1.getFullMap(), map2.getFullMap(), false);
    }

    private boolean oneVirtualOpponentMove() {
        handler.clearEvents();
        boolean shoot = true;
        boolean hasShips = true;
        while (shoot && hasShips) {
            Cell cell = opponent.getNextShoot(2);
            if (map1.isNotShootedCell(cell)) {
                shoot = opponentShoot(cell);
            } else {
                continue;
            }
            hasShips = map1.haveAliveShips();
        }
        return hasShips;
    }

    private boolean opponentShoot(Cell cell) {
        int aliveShips = map1.getNumberAliveShips();
        boolean shoot = map1.shootByCell(cell);
        if (aliveShips != map1.getNumberAliveShips()) {
            opponent.updateAfterShoot(shoot, true);
        } else {
            opponent.updateAfterShoot(shoot, false);
        }
        System.out.printf("%15s Ваша карта \n", "");
        OutputUtils.printMap(map1.getFullMap());
        System.out.println(handler.getStringEvents());
        handler.clearEvents();
        return shoot;
    }

    //    public static void main(String[] args) {
    //        for (int i=0;i<1;i++) {
    //            SingleGameMaster sm = new SingleGameMaster(new InputUtils(new BufferedReader(new
    // InputStreamReader(System.in))), new OutputUtils(new BufferedReader(new
    // InputStreamReader(System.in))));
    ////        sm.map1.addShip(new Ship(new Cell("а",2),new Cell("г",2)));
    //            while (sm.map1.haveAliveShips()) {
    //                sm.oneVirtualOpponentMove();
    //            }
    //            System.out.println("НОВАЯ ИГРА+++++++++++++++++++++++++++++++++++++++++++");
    //        }
    //
    //    }

}
