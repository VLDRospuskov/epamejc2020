package main.homeworks.Homework3.Arrays;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Engine {

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            RandomCharArray array = new RandomCharArray();
            int choice;
            System.out.println("Welcome to an Array test program!");

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
                        System.out.println("Wrong input, try again!");
                        break;
                }
            } while (choice != 5);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int menu(BufferedReader reader) {

        System.out.println("\n" +
                "_________________________________________________\n" +
                "|1. Array input                                 |\n" +
                "|2. Display an array                            |\n" +
                "|3. Display every odd row and column as string  |\n" +
                "|4. Display every even row and column as string |\n" +
                "|5. Exit                                        |\n" +
                "|_______________________________________________|");

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

