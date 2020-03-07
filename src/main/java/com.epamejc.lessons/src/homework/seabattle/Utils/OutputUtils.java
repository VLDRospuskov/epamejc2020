package com.epamejc.lessons.src.homework.seabattle.Utils;

import com.epamejc.lessons.src.homework.seabattle.Map.BattleMap;
import com.epamejc.lessons.src.homework.seabattle.Map.Cell;

import java.io.BufferedReader;
import java.io.IOException;

public class OutputUtils {
    private final BufferedReader bufferedReader;

    public OutputUtils(BufferedReader bf) {
        bufferedReader = bf;
    }

    public static void printMap(Cell[][] map) {
        System.out.printf("%3s", "");
        for (String letter : BattleMap.letters) {
            System.out.printf("%4s", letter);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%4d", i + 1);
            for (int k = 0; k < 10; k++) {
                System.out.printf("%4s", map[i][k].getStatus());
            }
            System.out.println();
        }
    }

    public static void print2Map(Cell[][] playerMap, Cell[][] opponentMap, boolean printHeader) {
        if (printHeader) {
            System.out.printf("%15s Ваша карта %40s Карта соперника \n", "", "");
        }
        for (int player = 0; player < 2; player++) {
            System.out.printf("%3s", "");
            for (String letter : BattleMap.letters) {
                System.out.printf("%4s", letter);
            }
            System.out.printf("%11s", "");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int player = 0; player < 2; player++) {
                Cell[][] map = (player == 0) ? playerMap : opponentMap;
                System.out.printf("%4d", i + 1);
                for (int k = 0; k < 10; k++) {
                    System.out.printf("%4s", map[i][k].getStatus());
                }
                System.out.printf("%10s", "");
            }
            System.out.println();
        }
    }

    public static void printHeaderForEndMap(String name1, String name2) {
        System.out.println("\nКарты к концу игры:");
        String spaces = "%" + (57 - name1.length()) + "s";
        System.out.printf("%17s %s" + spaces + " %s \n", "", name1, "", name2);
    }

    public static void printEmptyLines() {
        for (int i = 0; i < 500; i++) {
            System.out.println();
        }
    }

    public static void printGameStateBeforeMove(
            BattleMap playerMap, BattleMap opponentMap, String events) {
        System.out.printf("%s , ваш ход!", playerMap.getOwner());
        if (!events.isEmpty()) {
            System.out.println(" События за ход соперника: \n");
            System.out.println(events);
        }
        System.out.println(" Состояние игры: \n");
        OutputUtils.print2Map(playerMap.getFullMap(), opponentMap.getMapWithoutShip(), true);
    }

    public static void endGame(String winner) {
        System.out.printf("Игрок %s победил! Игра закончена.", winner);
    }

    public static void printShootResult(BattleMap opponentMap, boolean shoot, boolean hasShips) {
        if (shoot) {
            System.out.println("Попадание!");
            if (!hasShips) {
                System.out.println("У противника не осталось кораблей");
            } else {
                int ships = opponentMap.getNumberAliveShips();
                System.out.printf("Количество кораблей которые остались у противника : %d  .\n", ships);
                System.out.println("Ваш ход продолжается!");
            }
        } else {
            System.out.println("Промах!");
        }
    }

    public void nextPlayer() throws IOException {
        System.out.println("Нажмите ENTER и передайте консоль другому игроку \n");
        this.bufferedReader.readLine();
        printEmptyLines();
        System.out.println("Нажмите ENTER для начала ");
        bufferedReader.readLine();
    }

    public void nextVirtualPlayer() throws IOException {
        System.out.println("Нажмите ENTER для передачи хода \n");
        this.bufferedReader.readLine();
        printEmptyLines();
    }

}
