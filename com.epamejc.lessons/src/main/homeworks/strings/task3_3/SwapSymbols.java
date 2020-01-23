package main.homeworks.strings.task3_3;

import java.util.Scanner;

public class SwapSymbols {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input source string");
        String inputString = scanner.nextLine();
        System.out.println("Input two swapNums nums");
        System.out.println("For example");
        System.out.println("4, 1");
        String swapString = scanner.nextLine();
        Scanner subScanner = new Scanner(swapString).useDelimiter("\\s*, \\s*");
        int[] swapNums = new int[2];
        int count = 0;
        while (subScanner.hasNextInt() && count <= 2){
            swapNums[count] = subScanner.nextInt();
            count++;
        }
        scanner.close();
        subScanner.close();
        char swapChar;
        if ((swapNums[0] < inputString.length()) && (swapNums[0] >= 0) &&
                (swapNums[1] < inputString.length()) && (swapNums[1] > 0)){
            StringBuffer stringBuffer = new StringBuffer(inputString);
            swapChar = stringBuffer.charAt(swapNums[0]);
            stringBuffer.setCharAt(swapNums[0], stringBuffer.charAt(swapNums[1]));
            stringBuffer.setCharAt(swapNums[1],swapChar);
            System.out.println(stringBuffer.toString());
        } else {
            System.out.println("Nums are too big for this string");
        }
    }
}
