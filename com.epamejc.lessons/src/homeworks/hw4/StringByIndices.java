package homeworks.hw4;

import java.util.Scanner;

public class StringByIndices {

    public static void makeString(String inputString) {
        Scanner in = new Scanner(System.in);
        Integer index;
        String resultString = "";

        while (true) {
            System.out.print("Enter index (or type 'exit' to finish): ");

            if (in.hasNextInt()) {
                index = in.nextInt();
                while (index > inputString.length()) {
                    System.out.println("Input index is bigger than string's length, enter again.");
                    index = in.nextInt();
                }
                resultString += inputString.charAt(index);
                System.out.println(resultString);
            }

            if (in.hasNextLine() && in.nextLine().equalsIgnoreCase("exit")) {
                System.out.println(resultString);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input string: ");
        String inString = in.nextLine();
        makeString(inString);
    }

}
