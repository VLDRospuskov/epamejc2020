package com.epamejc.lessons.src.homework.seabattle;

import com.epamejc.lessons.src.homework.seabattle.Game_Masters.PairGameMaster;
import com.epamejc.lessons.src.homework.seabattle.Game_Masters.SingleGameMaster;
import com.epamejc.lessons.src.homework.seabattle.Utils.InputUtils;
import com.epamejc.lessons.src.homework.seabattle.Utils.OutputUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    private final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));
    private final InputUtils inputUtils = new InputUtils(bufferedReader);
    private final OutputUtils outputUtils = new OutputUtils(bufferedReader);

    public void start() {
        try {
            int option = inputUtils.getGameOption();
            if (option == 1) {
                new PairGameMaster(inputUtils, outputUtils).start();
            } else {
                new SingleGameMaster(inputUtils, outputUtils).start();
            }
        } catch (IOException e) {
            System.err.println("Произошла неожиданная ошибка ввода/вывода.");
        }
    }
}
