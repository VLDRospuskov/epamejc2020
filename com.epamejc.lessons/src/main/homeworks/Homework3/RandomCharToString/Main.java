package main.homeworks.Homework3.RandomCharToString;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        RandomCharGenerator charGen1 = new RandomCharGenerator(5, 9);

        charGen1.print();
        charGen1.print(Strategy.A);
        charGen1.print(Strategy.B);

    }
}
