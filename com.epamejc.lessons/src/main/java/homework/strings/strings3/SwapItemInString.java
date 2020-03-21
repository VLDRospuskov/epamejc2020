package main.java.homework.strings.strings3;
import java.util.Scanner;

public class SwapItemInString {
   private Scanner scanner;
    private String stringIn;
    private int index1;
    private int index2;

    public void run() {
        stringInput();
        indexInput();
        scrambleString();
    }

    private void stringInput() {
            scanner = new Scanner(System.in);
            System.out.print("Input your string: ");
            stringIn = scanner.nextLine();
        }

        private void indexInput() {

            System.out.print("Input the first index, then press 'enter' to input the second one ");
             index1 = scanner.nextInt();
             index2 = scanner.nextInt();
        }

        private void scrambleString() {

            StringBuilder scrambleString = new StringBuilder(stringIn);
            char symbol1 = scrambleString.charAt(index1);
            char cash = scrambleString.charAt(index2);
            scrambleString.setCharAt(index2, symbol1);
            scrambleString.setCharAt(index1, cash);
            System.out.println(scrambleString.toString());
        }

    }

