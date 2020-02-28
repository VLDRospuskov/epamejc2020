package homeworks.homework2.strings.task3_2;

import homeworks.InputReader;

public class StringGenerator {

    public String collectViaIndex(String inputString) {
        StringBuffer stringBuffer = new StringBuffer();
        int nextInt;
        System.out.println("Input index to continue OR negative number to stop");
        do {
            nextInt = InputReader.nextInt();
            generateString(inputString, stringBuffer, nextInt);
        } while (nextInt >= 0);
        return stringBuffer.toString();
    }

    private void generateString(String sourceString, StringBuffer stringBuffer, int nextInt) {
        if ((nextInt < sourceString.length()) && (nextInt >= 0)) {
            stringBuffer.append(sourceString.charAt(nextInt));
        } else {
            System.out.println("Number is too big or too low");
        }
        System.out.println(stringBuffer.toString());
    }

}
