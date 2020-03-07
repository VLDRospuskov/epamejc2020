package com.epamejc.lessons.src.homework.seabattle.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CellStatus {
    EMPTY("[ ]"),
    HIT("[X]"),
    MISS("[◉]"),
    SHIP("[■]");
    private String status;

    public String toString() {
        return status;
    }
}
