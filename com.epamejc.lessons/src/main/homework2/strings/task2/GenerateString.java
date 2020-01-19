package main.homework2.strings.task2;

import java.io.*;

public class GenerateString {
    static {
        System.out.println("Enter some string and then enter the indices of the letters you want to add " +
                "to the new string." + "\n" + "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //перезапуск программы в цикле; если введено "exit" - завершение
    protected void start() {
        try {
            while (true) {
                System.out.println("Enter the string:");
                String inputString = reader.readLine();
                if (!inputString.equals("exit")) {
                    generateString(inputString);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    private void generateString(String inputString) throws IOException {
        String result = "";
        String letter;
        System.out.println("Enter the indices. If you want restart program with new string - enter \"end\".");

        while (true) {
            letter = reader.readLine();
            if (letter.equals("end")) {
                break;
            } else if (letter.equals("exit")) {
                System.exit(0);
                reader.close();
            } else {
                try {
                    int letterIndex = Integer.parseInt(letter);
                    result += inputString.charAt(letterIndex);
                    System.out.println(result);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("The index is bigger than the length of the string. Try again.");
                } catch (NumberFormatException e) {
                    System.out.println("Apparently, you did not enter an integer. Try again.");
                }
            }
        }
    }
}
