package homework.strings.strings2;

import java.util.Scanner;

public class StringIndex {
    private Scanner scanner;
    private String stringIn;
    private String result = "";

public void run(){
    strInput();
    createByIndex();
}



        private void strInput() {
            scanner = new Scanner(System.in);
            System.out.print("Input your string: ");
            stringIn = scanner.nextLine();
            System.out.println("Input the string index");
        }


        private void createByIndex() {
            for (int i = 0; i < stringIn.length(); i++) {
                int index = scanner.nextInt();
                char symbol = stringIn.charAt(index);
                result = result + symbol;
                System.out.println(result);
            }
        }


        }



