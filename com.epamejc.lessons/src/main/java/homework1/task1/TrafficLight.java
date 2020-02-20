package homework1.task1;


import HomeworksReaderAndPrinter.*;

import java.io.IOException;

class TrafficLight {

    void start(Reader reader, Printer printer) {
        System.out.println("Enter the amount of minutes (it could be integer or float)." + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                String time = reader.read();
                if (!time.equalsIgnoreCase("exit")) {
                    try {

                        printer.print(chooseColor(time));
                    } catch (Exception e) {
                        System.out.println("Incorrect input.Try again.");
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

    String chooseColor(String time) {
        String result;
        double minute = Double.parseDouble(time);
        if (minute % 10 <= 3) {
            result = "Green signal";
        } else if (minute % 10 > 3 & minute % 10 <= 5) {
            result = "Yellow signal";
        } else if (minute % 10 > 5) {
            result = "Red signal";
        } else {
            throw new RuntimeException("Incorrect input.Try again.");
        }
        return result;
    }
}

