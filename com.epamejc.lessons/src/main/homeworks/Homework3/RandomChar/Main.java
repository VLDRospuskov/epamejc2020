package main.homeworks.Homework3.RandomChar;

public class Main {
    public static void main(String[] args) {

        RandomCharGenerator charGen1 = new RandomCharGenerator();
        RandomCharGenerator charGen2 = new RandomCharGenerator(12, 5);
        charGen1.generateArr();
        charGen2.generateArr();

        charGen1.print();
        charGen2.print();
    }
}
