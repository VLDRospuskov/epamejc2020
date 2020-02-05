package main.homeworks.hw4.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static main.homeworks.hw4.enums.Messages.*;

public class Logic {

    private void returnEvenOrOddChars(BufferedReader buffer) {
        System.out.println(EVEN_OR_ODD_ENTER_MESSAGE);

        try {
            String line = buffer.readLine();
            String strategy = buffer.readLine();

            EvenOddReturner returner = new EvenOddReturner();
            returner.evenOddReturn(line, strategy);

        } catch (IOException e) {
            System.out.println(INPUT_WARNING);
        }

    }

    private void makeLineByIndexes(BufferedReader buffer) {
        System.out.println(LINE_FROM_INDEXES_ENTER_MESSAGE);

        try {
            String line = buffer.readLine();
            String numbers = buffer.readLine();

            String[] numsWithoutSpaces = numbers.split(" ");
            ArrayList<Integer> indexes = new ArrayList<>();
            try {
                for (String nums : numsWithoutSpaces) {
                    indexes.add(Integer.parseInt(nums));
                }
            } catch (Exception e) {
                System.out.println(ONLY_POSITIVE_NUMBER_WARNING);
            }

            LineByIndexesMaker maker = new LineByIndexesMaker();
            maker.makeTheLineByIndexes(line, indexes);

        } catch (IOException e) {
            System.out.println(INPUT_WARNING);
        }
    }

    private void replaceChars(BufferedReader buffer) {
        System.out.println(REPLACE_CHARS_ENTER_MESSAGE);

        try {
            String line = buffer.readLine();
            String num1 = buffer.readLine();
            String num2 = buffer.readLine();

            int ind1 = Integer.parseInt(num1);
            int ind2 = Integer.parseInt(num2);

            CharsReplacer replacer = new CharsReplacer();
            replacer.replaceTwoChars(line, ind1, ind2);
        } catch (IOException e) {
            System.out.println(INPUT_WARNING);
        }

    }

    private void reverseWords(BufferedReader buffer) {
        System.out.println(REVERSE_WORDS_ENTER_MESSAGE);

        try {
            String line = buffer.readLine();

            WordsReverser reverser = new WordsReverser();
            reverser.reverseWordsAnPutOnInitialPlaces(line);
        } catch (IOException e) {
            System.out.println(INPUT_WARNING);
        }
    }

    public void run() {
        System.out.println(STRINGS_ENTER_MESSAGE);

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            String line = buffer.readLine();
            int taskNum = Integer.parseInt(line);

            switch (taskNum) {
                case 1:
                    returnEvenOrOddChars(buffer);
                    break;
                case 2:
                    makeLineByIndexes(buffer);
                    break;
                case 3:
                    replaceChars(buffer);
                    break;
                case 4:
                    reverseWords(buffer);
                    break;
                default:
                    System.out.println(WARNING_FOR_TASK_NUMBER_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WARNING_FOR_PARSING_TO_INT);
        }

    }
}
