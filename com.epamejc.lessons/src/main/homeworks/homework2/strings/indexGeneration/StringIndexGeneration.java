package main.homeworks.homework2.strings.indexGeneration;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringIndexGeneration {
    private String input;

    public void run() {
        inputString();
        generateNewString();
    }

    private void inputString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter string: ");
            input = br.readLine();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private void generateNewString() {
        String newString = "";
        System.out.print("Enter index('-1' - the end): ");
        Scanner scanner = new Scanner(System.in);
        int index;
        while (true){
            index = scanner.nextInt();
            if (index == -1) {
                break;
            }
            newString += input.charAt(index);
            System.out.println(newString);
        };
        scanner.close();
    }


    /*public void run() throws IOException {
        inputString();
        creationNewString();
    }

    private void inputString() throws IOException {
        BufferedReader br = createBufferedReader();
        try {
            System.out.print("Enter string: ");
            input = br.readLine();
            System.out.println("Enter the number of characters in the new string: ");
            //strLength = intPositiveInput();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        br.close();
    }

    private void creationNewString() {
        String output = "";
        for(int k = 0; k < strLength; k++) {
           // int index = intPositiveInput();
          //  output += input.charAt(index);
        }
        System.out.println(output);
    }

    private BufferedReader createBufferedReader() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br;
    }

    private int intPositiveInput(BufferedReader br) {
        int value = -1;
        String input = "";
        while (value == -1) {
            try {
                input = br.readLine();
                value = Integer.parseInt(input);
                if (value < 0) {
                    value = -1;
                    throw new ArithmeticException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }  catch (ArithmeticException e) {
                System.out.println("Enter the positive number!");;
            }  catch (Exception e) {
                System.out.println("Enter the positive integer number!");;
            }
        }
        return value;
    }*/
}
