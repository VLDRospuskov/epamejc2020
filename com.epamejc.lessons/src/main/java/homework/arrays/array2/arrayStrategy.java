package main.java.homework.arrays.array2;
import java.util.Scanner;


    public class arrayStrategy {

        int m;
        int n;
        char[][] charArray;
        double rand_num;
        Scanner scanner;

        public void run() {
            input();
            fillAndPrintTheArray();
            strategy();
        }

        private void input() {
            scanner = new Scanner(System.in);
            System.out.print("Input height: ");
            m = scanner.nextInt();
            System.out.print("Input length: ");
            n = scanner.nextInt();
            charArray = new char[m][n];
        }

        private void fillAndPrintTheArray() {
            int i;
            int j;

            for (i = 0; i < charArray.length; i++) {
                for (j = 0; j < charArray[i].length; j++) {
                    do {
                        rand_num = Math.random();
                        rand_num = rand_num * 1000;
                    } while (rand_num < 97 || rand_num > 122);

                    char random = (char) rand_num;
                    charArray[i][j] = random;
                    System.out.printf("%c ", charArray[i][j]);
                }
                System.out.println();
            }
        }

        private void strategy() {
            System.out.println("Choose the strategy A or B ");
            scanner = new Scanner(System.in);
            String strategy = scanner.nextLine();


            if (strategy.equals("A") || strategy.equals("a")) {
                for (int i = 0; i < charArray.length; i += 2) {
                    for (int j = 0; j < charArray[i].length; j += 2) {
                        System.out.printf("%c ", charArray[i][j]);
                    }
                }
            } else if (strategy.equals("B") || strategy.equals("b")) {
                for (int i = 1; i < charArray.length; i += 2) {
                    for (int j = 1; j < charArray[i].length; j += 2) {
                        System.out.printf("%c ", charArray[i][j]);
                    }
                }
            }
        }
    }
