package main.homeworks.strings.task3_4;

import java.util.Scanner;

public class ReverseWords {

    public void getReversedString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input source string");
        String inputString = scanner.nextLine();
        scanner.close();
        Scanner subScanner = new Scanner(inputString).useDelimiter("\\s* \\s*");
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer reverse = new StringBuffer();
        while (subScanner.hasNext()) {
            reverse.append(subScanner.next());
            stringBuffer.append(reverse.reverse()).append(" ");
            reverse.delete(0, reverse.length());
        }
        subScanner.close();
        System.out.println(stringBuffer.toString());
    }
}
