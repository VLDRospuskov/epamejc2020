package homeworks.homework3.pyramidGenerator;

import homeworks.homework3.allInOne.Colors;
import homeworks.homework3.allInOne.ThreadController;

import java.util.concurrent.ThreadLocalRandom;

public class PyramidGenerator {

    public void generate(String numberOfLevels) {

                if (isPositiveAndNotZero(numberOfLevels)) {
                    printPyramid(Integer.parseInt(numberOfLevels));
                } else {
                    System.out.println("Number of levels for pyramid should be an integer and over zero");
                }
    }

    private void printPyramid(int levels) {
        synchronized (ThreadController.sync) {
            System.out.println("\n*************Pyramid*************");
            for (int i = levels; i > 0; i--) {
                for (int j = i; j > 0; j--) {
                    System.out.print(Colors.colors[ThreadLocalRandom.current().nextInt(1, 9)] + " ■ " + Colors.colors[0]);
                }
                System.out.print("\n");
            }
        }
    }

    private boolean isPositiveAndNotZero (String str) {
        String regexInteger = "^-?\\d+$";
        return str.matches(regexInteger) && Integer.parseInt(str) > 0;
    }
}
