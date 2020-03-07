package com.epamejc.lessons.src.homework.homework8.java8.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobHistoryEntry {
    private final int duration;
    private final String position;
    private final String company;

}