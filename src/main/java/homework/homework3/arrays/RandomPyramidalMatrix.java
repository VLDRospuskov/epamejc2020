package homework.homework3.arrays;

public class RandomPyramidalMatrix extends CharMatrix {

    public RandomPyramidalMatrix(int rowsCount){
        RandomCharacterGenerator randomCharacterGenerator = new RandomCharacterGenerator();

        matrix = new char[rowsCount][];

        for (int i = 0; i < rowsCount; i++){
            int sizeI = rowsCount - i;
            matrix[i] = new char[sizeI];
            for (int j = 0; j < sizeI; j++){
                matrix[i][j] = randomCharacterGenerator.getRandomChar();
            }
        }
    }


}
