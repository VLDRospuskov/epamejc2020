package lesson2;

import java.util.Scanner;

public class Task33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = in.nextLine().toString();
        System.out.print("Enter first word (0 to " + (str.length() - 1) + "): ");

        String fw = in.nextLine().toString();
        if(!((Integer.parseInt(fw)>=-1)&&(Integer.parseInt(fw)<str.length())))
        {
            System.out.println("Err!");
            return;
        }
        System.out.print("Enter second word (" + (Integer.parseInt(fw) + 1) + " to " + (str.length() - 1) + "): ");
        String sw = in.nextLine().toString();
        if(!((Integer.parseInt(fw)>=((Integer.parseInt(fw)+1))&&(Integer.parseInt(fw)<str.length()))))
        {
            System.out.println("Err!");
            return;
        }
        System.out.println(str.substring(0, Integer.parseInt(fw))
                + str.charAt(Integer.parseInt(sw))
                + str.substring(Integer.parseInt(fw) + 1, Integer.parseInt(sw))
                + str.charAt(Integer.parseInt(fw))
                + str.substring(Integer.parseInt(sw) + 1, str.length()));


    }
}
