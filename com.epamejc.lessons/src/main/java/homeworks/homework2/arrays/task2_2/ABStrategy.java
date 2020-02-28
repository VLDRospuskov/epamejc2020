package homeworks.homework2.arrays.task2_2;

import homeworks.InputReader;

public class ABStrategy {

    public String selectStrategy(char[][] inputArray) {
        System.out.println("Input \"A\" or \"B\" to select specific strategy");
        String inputString = InputReader.nextString();
        String result;
        switch (inputString.toUpperCase()) {
            case "A":
               result = useAStrategy(inputArray);
                break;
            case "B":
               result =  useBStrategy(inputArray);
                break;
            default:
                System.out.println("Wrong input");
                result = "";
                break;
        }
        return result;
    }

    private String useAStrategy(char[][] inputArray) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < inputArray.length; i += 2) {
            for (int j = 0; j < inputArray[0].length; j += 2) {
                stringBuffer.append(inputArray[i][j]);
            }
        }
        return stringBuffer.toString();
    }

    private String useBStrategy(char[][] inputArray) {
        StringBuffer stringBuffer = new StringBuffer();
        if ((inputArray.length > 1) && (inputArray[0].length > 1)) {
            for (int i = 1; i < inputArray.length; i += 2) {
                for (int j = 1; j < inputArray[0].length; j += 2) {
                    stringBuffer.append(inputArray[i][j]);
                }
            }
            return stringBuffer.toString();
        } else {
            System.out.println("Too short for B strategy");
            return "";
        }
    }

}
