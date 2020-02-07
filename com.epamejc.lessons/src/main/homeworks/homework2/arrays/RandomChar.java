package homeworks.homework2.arrays;

import homeworks.control.services.ServiceImpl;

public class RandomChar extends ServiceImpl {

    @Override
    public String getResult(String userRequest) {
        Integer[] input = chekArray(userRequest);
        return makeArray(input[0], input[1]);
    }

    private String makeArray(int ind1, int ind2) {
        char[][] result = new char[ind1][ind2];
        for (int i = 0; i < ind1; i++) {
            for (int j = 0; j < ind2; j++) {
                result[i][j] = makeRandomChar();
            }
        }
        return arrayToString(result);
    }

    private String arrayToString(char[][] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                sb.append(result[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
