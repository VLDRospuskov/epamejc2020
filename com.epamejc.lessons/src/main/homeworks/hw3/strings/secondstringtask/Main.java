package main.homeworks.hw3.strings.secondstringtask;

import static main.homeworks.hw3.strings.secondstringtask.LineByIndex.makeTheLineByIndexes;

public class Main {

    public static void main(String[] args) {

        makeTheLineByIndexes("Hello World", 0, 4, 6, 8, 15);
        makeTheLineByIndexes("IndexIsOutOfBoundaries", 90, 15, 78, 5, 0);

    }
}
