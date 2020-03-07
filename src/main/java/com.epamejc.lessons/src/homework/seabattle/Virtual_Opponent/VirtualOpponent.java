package com.epamejc.lessons.src.homework.seabattle.Virtual_Opponent;

import com.epamejc.lessons.src.homework.seabattle.Map.BattleMap;
import com.epamejc.lessons.src.homework.seabattle.Map.Cell;
import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VirtualOpponent {
    private final BattleMap map;
    private final Deque<Cell> shootQueue = new ArrayDeque<>();
    private final Map<Integer, Integer> shipCount = new HashMap<>();
    private boolean findNewShip = false;
    private Deque<Cell> findShipQueue = new ArrayDeque<>();
    private int shootCount = 0;
    private Cell lastShootCell;
    private Cell penultimateShootCell;

    public VirtualOpponent(BattleMap map) {
        this.map = new RandomMapFiller(map).fillMap();
        organizeQueues();
        fillShipCount();
    }

    @SneakyThrows
    public Cell getNextShoot(int timeout) {
        penultimateShootCell = lastShootCell;
        if (!findNewShip) {
            lastShootCell = shootQueue.pollFirst();
        } else {
            lastShootCell = findShipQueue.pollFirst();
        }
        TimeUnit.SECONDS.sleep(timeout);
        return lastShootCell;
    }

    public void updateAfterShoot(boolean shoot, boolean kill) {
        if (shoot) {
            shootCount++;
            if (kill) {
                findNewShip = false;
                findShipQueue.clear();
                updateShipCount(shootCount);
                shootCount = 0;
            } else if (!findNewShip) {
                findNewShip = true;
                initShipQueue(lastShootCell);
            }
        } else if (findNewShip) {
            changeFindQueue();
        }
    }

    private void changeFindQueue() {
        Predicate<Cell> predicate;
        if (lastShootCell.getNumber() > penultimateShootCell.getNumber()) {
            predicate = Cell.isCellLowerThan(lastShootCell);
        } else if (lastShootCell.getNumber() < penultimateShootCell.getNumber()) {
            predicate = Cell.isCellHigherThan(lastShootCell);
        } else if (lastShootCell.getLetter().compareTo(penultimateShootCell.getLetter()) > 0) {
            predicate = Cell.isCellMoreLeftThan(lastShootCell);
        } else {
            predicate = Cell.isCellMoreRightThan(lastShootCell);
        }
        findShipQueue =
                findShipQueue.stream().filter(predicate).collect(Collectors.toCollection(ArrayDeque::new));
    }

    private void fillShipCount() {
        for (int i = 4; i > 0; i--) {
            shipCount.put(i, 5 - i);
        }
    }

    private int getMaxSizeShip() {
        return shipCount.keySet().stream().max(Integer::compareTo).get();
    }

    private void updateShipCount(int shootCount) {
        Integer value = shipCount.get(shootCount);
        if (value - 1 == 0) {
            shipCount.remove(shootCount);
        } else {
            shipCount.put(shootCount, value - 1);
        }
    }

    private void initShipQueue(Cell cell) {
        int maxSize = getMaxSizeShip();
        int indexLetter = Arrays.binarySearch(BattleMap.letters, cell.getLetter());
        for (int i = indexLetter; i < BattleMap.letters.length; i++) {
            if (i - indexLetter < maxSize && indexLetter != i) {
                findShipQueue.add(new Cell(BattleMap.letters[i], cell.getNumber()));
            }
        }
        for (int i = indexLetter; i >= 0; i--) {
            if (indexLetter - i < maxSize && indexLetter != i) {
                findShipQueue.add(new Cell(BattleMap.letters[i], cell.getNumber()));
            }
        }
        for (int i = cell.getNumber(); i < 11; i++) {
            if (i - cell.getNumber() < maxSize && i != cell.getNumber()) {
                findShipQueue.add(new Cell(cell.getLetter(), i));
            }
        }
        for (int i = cell.getNumber(); i > 0; i--) {
            if (i - cell.getNumber() < maxSize && i != cell.getNumber()) {
                findShipQueue.add(new Cell(cell.getLetter(), i));
            }
        }
    }

    private void organizeQueues() {
        shootQueue.addAll(getShootQueue(4, 4));
        shootQueue.addAll(getShootQueue(2, 4));
        shootQueue.addAll(getShootQueue(1, 2));
    }

    private Collection<Cell> getShootQueue(int firstValue, int step) {
        Deque<Cell> queue = new ArrayDeque<>();
        int temp = firstValue;
        for (String letter : BattleMap.letters) {
            for (int i = temp; i < 11; i += step) {
                queue.add(new Cell(letter, i));
            }
            temp = temp > 1 ? temp - 1 : step;
        }
        return queue;
    }
}
