package com.epamejc.lessons.src.homework.seabattle.Map;

import java.util.*;
import java.util.stream.Collectors;

public class BattleMap {
    public static final String[] letters = {"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К"};
    private final Cell[][] map = new Cell[10][10];
    private final List<Ship> ships = new ArrayList<>();
    private final String owner;
    private final EventHandler handler;
    private String opponent = "Противник";

    public BattleMap(String owner, EventHandler handler) {
        this.owner = owner;
        this.handler = handler;
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                map[i][k] = new Cell(letters[k], i + 1);
            }
        }
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public Cell[][] getFullMap() {
        return map;
    }

    public Cell[][] getMapWithoutShip() {
        Cell[][] mapWithoutShips = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                if (map[i][k].getStatus() != CellStatus.SHIP) {
                    mapWithoutShips[i][k] = new Cell(letters[k], i + 1, map[i][k].getStatus());
                } else {
                    mapWithoutShips[i][k] = new Cell(letters[k], i + 1);
                }
            }
        }
        return mapWithoutShips;
    }

    public String getOwner() {
        return owner;
    }

    public boolean shootByCell(Cell cell) {
        for (Ship ship : ships) {
            boolean shoot = ship.shootByCell(cell);
            if (shoot) {
                updateByCell(cell, CellStatus.HIT);
                handler.addHitEvent(opponent, cell.getLocation());
                if (ship.isDead()) {
                    handler.addShipDeadEvent(owner);
                    updateEmptyCellAroundShip(ship);
                }
                return true;
            }
        }
        updateByCell(cell, CellStatus.MISS);
        handler.addMissEvent(opponent, cell.getLocation());
        return false;
    }

    public boolean addShip(Ship ship) {
        List<Cell> location = ship.getLocation();
        Set<Cell> cellsForShip = new HashSet<>();
        for (Cell cell : location) {
            cellsForShip.addAll(getCellsAround(cell));
        }
        cellsForShip.addAll(location);
        for (Cell cell : cellsForShip) {
            if (getCellStatusByLetterAndNumber(cell.getLetter(), cell.getNumber()) == CellStatus.SHIP) {
                return false;
            }
        }
        for (Cell cell : location) {
            updateByCell(cell, CellStatus.SHIP);
        }
        ships.add(ship);
        return true;
    }

    public boolean haveAliveShips() {
        for (Ship ship : ships) {
            if (!ship.isDead()) return true;
        }
        return false;
    }

    public int getNumberAliveShips() {
        return (int) ships.stream().filter(ship -> !ship.isDead()).count();
    }

    public boolean isNotShootedCell(Cell cell) {
        CellStatus status = getCellStatusByLetterAndNumber(cell.getLetter(), cell.getNumber());
        return status != CellStatus.MISS && status != CellStatus.HIT;
    }

    private void updateByCell(Cell cell, CellStatus cellStatus) {
        int letterIndex = Arrays.binarySearch(letters, cell.getLetter());
        int numberIndex = cell.getNumber() - 1;
        map[numberIndex][letterIndex].setStatus(cellStatus);
    }

    private CellStatus getCellStatusByLetterAndNumber(String letter, int number) {
        int letterIndex = Arrays.binarySearch(letters, letter);
        int numberIndex = number - 1;
        return map[numberIndex][letterIndex].getStatus();
    }

    private void updateEmptyCellAroundShip(Ship ship) {
        List<Cell> shipCells = ship.getLocation();
        List<Cell> missCell = getCellsAroundShip(shipCells);
        for (Cell cell : missCell) {
            cell.setStatus(CellStatus.MISS);
        }
    }

    private List<Cell> getCellsAroundShip(List<Cell> shipCells) {
        Set<Cell> cellsAround = new HashSet<>();
        for (Cell cell : shipCells) {
            cellsAround.addAll(getCellsAround(cell));
        }
        return cellsAround.stream()
                .filter(
                        cell -> {
                            for (Cell shCell : shipCells) {
                                if (shCell.equals(cell)) {
                                    return false;
                                }
                            }
                            return true;
                        })
                .collect(Collectors.toList());
    }

    private List<Cell> getCellsAround(Cell cell) {
        List<Cell> cells = new ArrayList<>();
        int letterIndex = Arrays.binarySearch(letters, cell.getLetter());
        int numberIndex = cell.getNumber() - 1;
        addTopCells(cells, letterIndex, numberIndex);
        addDownCells(cells, letterIndex, numberIndex);
        addRightLeftCells(cells, letterIndex, numberIndex);
        return cells;
    }

    private void addRightLeftCells(List<Cell> cells, int letterIndex, int numberIndex) {
        if (numberIndex > 0) {
            cells.add(map[numberIndex - 1][letterIndex]);
        }
        if (numberIndex < 9) {
            cells.add(map[numberIndex + 1][letterIndex]);
        }
    }

    private void addDownCells(List<Cell> cells, int letterIndex, int numberIndex) {
        if (letterIndex < letters.length - 1) {
            cells.add(map[numberIndex][letterIndex + 1]);
            addRightLeftCells(cells, letterIndex + 1, numberIndex);
        }
    }

    private void addTopCells(List<Cell> cells, int letterIndex, int numberIndex) {
        if (letterIndex > 0) {
            cells.add(map[numberIndex][letterIndex - 1]);
            addRightLeftCells(cells, letterIndex - 1, numberIndex);
        }
    }
}
