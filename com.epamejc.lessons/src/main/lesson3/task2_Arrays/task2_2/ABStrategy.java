package main.lesson3.task2_Arrays.task2_2;

import java.util.Scanner;

public class ABStrategy {

    public void selectStrategy(char[][] inputArray){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input \"A\" or \"B\" to select specific strategy");
        String inputString = scanner.nextLine();
        switch (inputString.toUpperCase()) {
        case "A":
            aStrategy(inputArray);
            break;
        case "B":
            bStrategy(inputArray);
            break;
        default:
            System.out.println("Wrong input");
        }
    }

    private void aStrategy(char[][] inputArray) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < inputArray.length; i += 2) {
            for (int j = 0; j < inputArray[0].length; j += 2) {
                stringBuffer.append(inputArray[i][j]);
            }
        }
        System.out.println(stringBuffer.toString());
    }

    private void bStrategy(char[][] inputArray) {
        StringBuffer stringBuffer = new StringBuffer();
        if ((inputArray.length > 1) &&(inputArray[0].length > 1)){
            for (int i = 1; i < inputArray.length; i += 2) {
                for (int j = 1; j < inputArray[0].length; j += 2) {
                    stringBuffer.append(inputArray[i][j]);
                }
            }
            System.out.println(stringBuffer.toString());
        } else {
            System.out.println("Too short for B strategy");
        }
    }
}
