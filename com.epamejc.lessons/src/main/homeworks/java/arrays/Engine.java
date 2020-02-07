package homeworks.java.arrays;

import java.io.*;

public class Engine {

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            RandomCharArray array = new RandomCharArray();
            int choice;
            System.out.println("Welcome to an Array test program!\n");

            do {
                choice = menu(reader);

                switch (choice) {
                    case 1:
                        array.generateArr(reader);
                        break;
                    case 2:
                        array.print();
                        break;
                    case 3:
                        array.print(Strategy.A);
                        break;
                    case 4:
                        array.print(Strategy.B);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.print("Wrong input, try again!\n");
                        break;
                }
            } while (choice != 5);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int menu(BufferedReader reader) {

        System.out.print("\n" +
                "_________________________________________________\n" +
                "|1. Array input                                 |\n" +
                "|2. Display an array                            |\n" +
                "|3. Display every odd row and column as string  |\n" +
                "|4. Display every even row and column as string |\n" +
                "|5. Exit                                        |\n" +
                "|_______________________________________________|\n");

        int input = 0;
        try {
            input = Integer.valueOf(reader.readLine());
        } catch (NumberFormatException e) {
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

}

