package homeworks.HW3_arrays.pyramidGeneration;

import java.util.Scanner;

public class PyramidApp {

    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (!isExitNeeded) {
                int pyramidHeight = definePyramidHeight(scan);
                if (!isExitNeeded) {
                    Pyramid pyramid = new Pyramid();
                    char[][] pyramidArray = pyramid.createPyramid(pyramidHeight);
                    pyramid.printPyramid(pyramidArray);
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println("Program ends. Goodbye.");
        }
    }

    /**
     * Method for initializing the height of the pyramid
     *
     * @param scan scanner object
     */
    public int definePyramidHeight(Scanner scan) {
        boolean isInputCorrect = false;
        int pyramidHeight = 0;
        while (!isInputCorrect) {
            System.out.print("Enter the height of the pyramid (Integer number from 2 to 55) or enter -1 to exit: ");
            String inputString = scan.nextLine();
            try {
                pyramidHeight = Integer.parseInt(inputString);
                if (pyramidHeight == -1) {
                    isExitNeeded = true;
                    break;
                } else if (pyramidHeight > 1 && pyramidHeight <= 55) {
                    isInputCorrect = true;
                } else {
                    throw new ArithmeticException();
                }
            } catch (Exception ex) {
                System.out.println("Wrong input. Enter correct number.");
            }
        }
        return pyramidHeight;
    }
}
