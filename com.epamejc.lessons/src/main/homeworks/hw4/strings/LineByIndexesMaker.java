package main.homeworks.hw4.strings;

import java.util.ArrayList;

public class LineByIndexesMaker {

    void makeTheLineByIndexes(String word, ArrayList<Integer> indexes) {

        StringBuilder line = new StringBuilder();

        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) >= 0 && indexes.get(i) < word.length()) {

                line.append(word.charAt(indexes.get(i)));

            } else {
                System.out.println("Attention: at least one of the indexes is bigger than word's length");
            }
        }

        System.out.println("Line from existing in the string indexes:");

        System.out.println(line);
    }
}
