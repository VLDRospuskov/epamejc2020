package com.epamejc.lessons.src.homework.seabattle.Utils;

import com.epamejc.lessons.src.homework.seabattle.Map.BattleMap;
import com.epamejc.lessons.src.homework.seabattle.Map.Cell;
import com.epamejc.lessons.src.homework.seabattle.Map.Ship;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {
    private final BufferedReader reader;

    public InputUtils(BufferedReader reader) {
        this.reader = reader;
    }

    public int getGameOption() throws IOException {
        System.out.println("Выберите режим игры : 1-парный или 2-одиночный");
        while (true) {
            try {
                int option = Integer.parseInt(reader.readLine());
                if (option == 1 || option == 2) {
                    return option;
                } else {
                    System.err.println("Число не равно 1 или 2. Попробуйте еще раз ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Ожидалось число 1 или 2. Попробуйте еще раз ");
            }
        }
    }

    public Ship getShip(int length) throws IOException {
        Ship ship;
        System.out.printf("Ввод корабля длины %o \n", length);
        while (true) {
            try {
                if (length > 1) {
                    System.out.println("Введите первую клетку");
                    Cell cell1 = getCell();
                    System.out.println("Введите последнюю клетку");
                    Cell cell2 = getCell();
                    ship = new Ship(cell1, cell2);
                    if (checkShipLength(length, ship)) continue;
                } else {
                    System.out.println("Введите клетку");
                    Cell cell = getCell();
                    ship = new Ship(cell);
                }
                return ship;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage() + ". Попробуйте еще раз");
            }
        }
    }

    public Cell getCell() throws IOException {
        Cell cell;
        while (true) {
            String line = reader.readLine();
            if (line.length() != 2 && line.length() != 3) {
                System.err.println("Ожидается строка состоящая из буквы и числа. Попробуйте еще раз");
            } else {
                try {
                    cell = new Cell(line.substring(0, 1), Integer.parseInt(line.substring(1)));
                    return cell;
                } catch (NumberFormatException e) {
                    System.err.println("Требуемый формат [Буква][Цифра]. Попробуйте еще раз ");
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage() + ". Попробуйте еще раз");
                }
            }
        }
    }

    public void fillMapByInput(BattleMap map) throws IOException {
        List<Ship> ships = new ArrayList<>();
        for (int i = 4; i > 0; i--) {
            int count = 0;
            System.out.printf("Ввод кораблей длиной: %o в количестве %o.\n", i, 5 - i);
            while (count != 5 - i) {
                Ship ship = getShip(i);
                boolean successful = map.addShip(ship);
                if (successful) {
                    ships.add(ship);
                    count++;
                } else {
                    System.err.println("Корабль не может находится в это месте. Повторите ввод \n");
                }
                OutputUtils.printMap(map.getFullMap());
            }
        }
        ships.forEach(map::addShip);
    }

    public String getPlayerName() throws IOException {
        while (true) {
            String name = reader.readLine();
            if (name.length() > 50) {
                System.err.println("Имя должно быть короче 50 символов \n");
                continue;
            }
            if (name.replace(" ", "").isEmpty()) {
                System.err.println("Имя не должно быть пустым \n");
                continue;
            }
            System.out.printf("Вас зовут %s ,верно? да|нет \n", name);
            String answer = reader.readLine();
            if (answer.toLowerCase().replace(" ", "").equals("да")) {
                return name;
            } else {
                System.err.println("Попробуйте ввести имя еще раз ");
            }
        }
    }

    private boolean checkShipLength(int length, Ship ship) {
        if (ship.getSize() != length) {
            System.err.printf(
                    "Длина корабля %o не соответсвует ожидаемой %o. Повторите ввод клеток.\n",
                    ship.getSize(), length);
            return true;
        }
        return false;
    }
}
