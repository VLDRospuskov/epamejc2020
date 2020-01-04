package homework.homework2.pyramidGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PyramidGenerator {

    void generate() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while(true) {

                System.out.print("Enter number of levels: ");
                String numberOfLevels = reader.readLine();

                if (isPositiveAndNotZero(numberOfLevels)) {
                    printPyramid(Integer.parseInt(numberOfLevels));
                } else if (numberOfLevels.equals("exit")) {
                    System.out.println("Generator stoped!");
                    break;
                } else {
                    System.out.println("Number of levels should be an integer and over zero");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void printPyramid(int levels) {
        for (int i = levels; i>0; i--) {
            for (int j = i; j>0; j--) {
                System.out.print(" ■ ");
            }
            System.out.print("\n");
        }
    }

    private boolean isPositiveAndNotZero (String str) {
        String regexInteger = "^-?\\d+$";
        return str.matches(regexInteger) && Integer.parseInt(str) > 0;
    }
}
