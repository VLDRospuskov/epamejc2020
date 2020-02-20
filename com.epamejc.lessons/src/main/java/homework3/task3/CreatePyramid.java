package homework3.task3;

import HomeworksReaderAndPrinter.Printer;
import HomeworksReaderAndPrinter.Reader;

import java.io.IOException;
import java.util.Arrays;

public class CreatePyramid {

    protected void start(Reader reader, Printer printer) {
        System.out.println("Enter the integer - it will be height of your pyramid." + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                String height = reader.read();
                if (!height.equals("exit")) {
                    try {
                        String[][] xPyramid = createPyramid(height);
                        printer.print(arrayAsString(xPyramid));
                        System.out.println("Enter the integer:");
                    } catch (Exception e) {
                        printer.print("Incorrect input.Try again.");
                    }
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

     String[][] createPyramid(String height) {
         int intHeight = Integer.parseInt(height);
         String[][] xPyramid = new String[intHeight][];
         for (int i = 0; i < intHeight ; i++) {
             xPyramid[i] = new String[intHeight - i];
         }
         for (String[] s : xPyramid) {
                Arrays.fill(s, "X");
            }
        return xPyramid;
    }

    private String arrayAsString(String[][] xPyramid) {
        StringBuilder builder = new StringBuilder();
        for (String[] strings : xPyramid) {
            for (String symbol : strings) {
                builder.append(symbol);
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
