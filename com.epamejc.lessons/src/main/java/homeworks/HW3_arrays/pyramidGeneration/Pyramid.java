package homeworks.HW3_arrays.pyramidGeneration;

public class Pyramid {

    public Pyramid() {
    }

    /**
     * Method for generating a pyramid
     *
     * @return generated pyramid
     */
    public char[][] createPyramid(int pyramidHeight) {
        char[][] pyramidCharArray = new char[pyramidHeight][2 * pyramidHeight - 1];
        try {
            for (int i = 0; i < pyramidCharArray.length; i++) {
                for (int j = 0; j < pyramidCharArray[i].length; j++) {
                    pyramidCharArray[i][j] = ' ';
                }
            }
            fillPyramid(pyramidCharArray);
        } catch (Exception exc) {
            System.out.println("An error occurred while creating the pyramid");
        }
        return pyramidCharArray;
    }

    /**
     * Method for printing the generated pyramid to the console
     *
     * @param charArray pyramid array
     */
    public void printPyramid(char[][] charArray) {
        System.out.println("Generated pyramid is: ");
        try {
            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < charArray[i].length; j++) {
                    System.out.print(charArray[i][j]);
                }
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("An error occurred while printing the pyramid");
        } finally {
            System.out.println();
        }
    }

    /**
     * Method for filling the array with chars
     *
     * @param pyramidArray pyramid array
     */
    private void fillPyramid(char[][] pyramidArray) {
        for (int i = 0; i < pyramidArray.length; i++) {
            for (int k = pyramidArray.length - 1 - i; k <= pyramidArray.length - 1 + i; k++) {
                pyramidArray[i][k] = 'X';
            }
        }
    }
}



