package main.homeworks.hw4.strings;

public class EvenOddReturner {

    void evenOddReturn(String word, String evenOrOdd) {
        if (evenOrOdd.equalsIgnoreCase("even")) {
            for (int i = 1; i < word.length(); ) {
                System.out.print(word.charAt(i));
                i = i + 2;
            }
        } else if (evenOrOdd.equalsIgnoreCase("odd")) {
            for (int i = 0; i < word.length(); ) {
                System.out.print(word.charAt(i));
                i = i + 2;
            }
        }
        System.out.println();
    }
}
