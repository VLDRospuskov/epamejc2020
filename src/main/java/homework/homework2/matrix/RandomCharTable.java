package homework.homework2.matrix;

public class RandomCharTable extends CharMatrix {

    public RandomCharTable(int rowsCount, int columnsCount){

        RandomCharacterGenerator randomCharacterGenerator = new RandomCharacterGenerator();
        this.matrix = new char[rowsCount][columnsCount];

        for (int i = 0; i < rowsCount; i++){
            for (int j = 0; j < columnsCount; j++){
                matrix[i][j] = randomCharacterGenerator.get();
            }
        }

    }
}
