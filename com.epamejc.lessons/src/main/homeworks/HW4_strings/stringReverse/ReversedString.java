package main.homeworks.HW4_strings.stringReverse;

import java.util.Scanner;

public class ReversedString {
    private boolean appInputExitTrigger = true;
    private String inputString = "";

    public void run(){
        Scanner scan = new Scanner(System.in);
        while (appInputExitTrigger) {
            enterString(scan);
            if(appInputExitTrigger){
                reverseStrings();
            }
        }
        scan.close();
        System.out.println(ReversedStringMessages.exitAppMessage.getValue());
    }

    private void enterString(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(ReversedStringMessages.enterStringMessage.getValue());
            inputString = _scan.nextLine();
            try {
                int exitTrigger = Integer.parseInt(inputString);
                if (exitTrigger == -1) {
                    appInputExitTrigger = false;
                    break;
                }
            } catch (Exception ex) {
            }
            if (inputString.length() > 0) {
                isInputCorrect = true;
            }
        }
    }

    private void reverseStrings() {
        System.out.println("Original string is: \n" + inputString);
        System.out.println("Reversed string is:");

        String[] splittedStrings = inputString.split("\\s+");
        for (String s : splittedStrings) {
            StringBuilder strBuilder = new StringBuilder(s);
            System.out.print(strBuilder.reverse().toString() + " ");
        }
        System.out.println();
    }
}
