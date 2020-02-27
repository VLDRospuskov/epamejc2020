package homeworks.java;

import static homeworks.java.seabattle.data.Field.deckSize;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < deckSize; i++) {
            for (int j = i - deckSize/4*4-2; j < deckSize; j += 4) {
                if (j >= 0) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
