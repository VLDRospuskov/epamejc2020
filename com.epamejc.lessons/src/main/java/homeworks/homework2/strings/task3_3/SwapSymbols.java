package homeworks.homework2.strings.task3_3;

import homeworks.InputReader;


public class SwapSymbols {

    public int[] getSwapNumsFromInput() {
        System.out.println("Input two swapNums nums");
        System.out.println("For example");
        System.out.println("4, 1");
        String swapString = InputReader.nextString();
        String[] splited = swapString.split(", ");
        int[] swapNums = new int[2];
        for (int i = 0; i < splited.length && i < swapNums.length; i++) {
            if (isNumeric(splited[i])) {
                swapNums[i] = Integer.parseInt(splited[i]);
            }
        }
        return swapNums;
    }

    public String swapCharsInString(int[] swapNums, String inputString) {
        char swapChar;
        if ((swapNums[0] < inputString.length()) && (swapNums[0] >= 0) && (swapNums[1] < inputString.length()) && (swapNums[1] > 0)) {
            StringBuffer stringBuffer = new StringBuffer(inputString);
            swapChar = stringBuffer.charAt(swapNums[0]);
            stringBuffer.setCharAt(swapNums[0], stringBuffer.charAt(swapNums[1]));
            stringBuffer.setCharAt(swapNums[1], swapChar);
            return stringBuffer.toString();
        } else {
            System.out.println("Nums are too big for this string");
            return "";
        }
    }

    private boolean isNumeric(String strToNum) {
        if (strToNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strToNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
