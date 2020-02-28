package homeworks.homework2.strings.task3_1;

import homeworks.InputReader;

public class OddEvenSubstring {

    public String useStrategy(String inputString) {
        System.out.println("Input \"odd\" or \"even\"");
        String mod = InputReader.nextString().toLowerCase();
        switch (mod) {
            case "even":
                return createStringFromEven(inputString);
            case "odd":
                return createStringFromOdd(inputString);
            default:
                System.out.println("wrong mod input");
                return "";
        }
    }

    private String createStringFromEven(String s) {
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

    private String createStringFromOdd(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i += 2) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }

}
