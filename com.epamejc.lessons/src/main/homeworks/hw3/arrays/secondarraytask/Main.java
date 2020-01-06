package main.homeworks.hw3.arrays.secondarraytask;

import static main.homeworks.hw3.arrays.secondarraytask.RandomCharsArray.*;

public class Main {

    public static void main(String[] args) {

        strategyAoutput(getCharsArray(5));
        strategyBoutput(getCharsArray(8));

        char[][] chars;
        chars = getCharsArray(7);
        strategyAoutput(chars);
        strategyBoutput(chars);
    }
}
