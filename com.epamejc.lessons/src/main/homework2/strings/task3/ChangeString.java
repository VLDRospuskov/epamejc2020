package main.homework2.strings.task3;

import java.io.*;

public class ChangeString {
    static {
        System.out.println("Enter some string and then enter indices of letters which you want to replace " +
                "(separated by a \", \")" + "\n" + "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String inputString;

    //перезапуск программы в цикле; если введено "exit" - завершение
    protected void start() {
        try {
            while (true) {
                System.out.println("Enter the string:");
                inputString = reader.readLine();
                if (!inputString.equals("exit")) {
                    inputCheck();
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    //Проверка ввода индексов (должен быть по форме "0, 1")
    private void inputCheck() throws IOException {
        while (true) {
            System.out.print("Enter indices: ");
            String inputIndices = reader.readLine();
            try {
                if (inputIndices.equals("exit")) {
                    System.exit(0);
                    reader.close();
                } else {
                    String[] indices = inputIndices.split(", ");
                    int index1 = Integer.parseInt(indices[0]);
                    int index2 = Integer.parseInt(indices[1]);
                    changeString(index1, index2);
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("The index is bigger than the length of the string. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Apparently, you did not enter an integer. Try again.");
            }
        }
    }


    private void changeString(int index1, int index2) {
        StringBuilder result = new StringBuilder(inputString);
        result.delete(index1, index1 + 1);
        result.insert(index1, inputString.charAt(index2));
        result.delete(index2, index2 + 1);
        result.insert(index2, inputString.charAt(index1));
        System.out.println(result);
    }
}

