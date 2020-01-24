package homework.strings;

import java.util.Scanner;

public class string2 {


        public static void main(String[] args) {


          Scanner in = new Scanner(System.in);
            System.out.print("Input your string: ");
            String stringIn = in.nextLine();
            System.out.println("Input the string index");
            String result = "";



           for (int i =0; i< stringIn.length(); i++) {
               int index = in.nextInt();
               char symbol = stringIn.charAt(index);
               result = result + symbol;
               System.out.println(result);
           }









        }
    }


