package homeworks.java.arrays;

import homeworks.java.utils.UserInputReader;

public class Engine {

    public void run() {

        RandomCharArray array = new RandomCharArray();
        int choice;
        System.out.println("Welcome to an Array test program!\n");

        do {
            choice = menu();

            switch (choice) {
                case 1:
                    array.generateArr();
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

    }

    private int menu() {

        System.out.print("\n" +
                "_________________________________________________\n" +
                "|1. Generate an array                           |\n" +
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

