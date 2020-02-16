package homework.homework2.matrix;

public class CharMatrix {

    public CharMatrix() {
    }

    public CharMatrix(char[][] charMatrix){
        matrix = charMatrix;
    }

    protected char[][] matrix;

    public void print() {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public char[][] getMatrix(){
        return matrix;
    }

    public String toStringStrategyA() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (j % 2 == 0) {
                        string.append(matrix[i][j]);
                    }
                }
            }
        }
        return string.toString();
    }

    public String toStringStrategyB() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < this.matrix.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    if (j % 2 != 0) {
                        string.append(matrix[i][j]);
                    }
                }
            }
        }
        return string.toString();
    }
}
