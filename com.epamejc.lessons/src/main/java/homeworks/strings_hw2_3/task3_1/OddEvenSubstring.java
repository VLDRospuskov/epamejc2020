package homeworks.strings_hw2_3.task3_1;

import homeworks.RunHomeWorksTasks;

import java.util.Scanner;

public class OddEvenSubstring {

//    public String useStrategy() {
//        System.out.println("Input string to transform");
//        //Scanner scanner = new Scanner(System.in);
//        RunHomeWorksTasks runHomeWorksTasks = new RunHomeWorksTasks();
//        String inputString = runHomeWorksTasks.readUserInput();
//        System.out.println("Input \"odd\" or \"even\"");
//        String mod = runHomeWorksTasks.readUserInput().toLowerCase();
//        switch (mod) {
//            case "even":
//                return createStringFromEven(inputString);
//            case "odd":
//                return createStringFromOdd(inputString);
//            default:
//                System.out.println("wrong mod input");
//                return "";
//        }
//    }

    public String createStringFromOdd(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i += 2) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }

    public String createStringFromEven(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        if (s.length() > 0) {
            for (int i = 1; i < s.length(); i += 2) {
                stringBuffer.append(s.charAt(i));
            }
        } else {
            System.out.println("String is too short for even");
        }

        return stringBuffer.toString();
    }

}
