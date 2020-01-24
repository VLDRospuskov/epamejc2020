package homework.strings;
import java.util.Scanner;

public class strings1 {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.print("Input your string: ");
        String stringIn = in.nextLine();


        System.out.println("Do you need even or odd symbols?");
        String evenOdd = in.nextLine();

        String option1 = ("even");
        String option2 = ("odd");


        if (evenOdd.equalsIgnoreCase(option1)) {
            for (int i = 0; i < stringIn.length(); i += 2) { //четный
                char result = stringIn.charAt(i);
                System.out.print(result);
            }
        } else if (evenOdd.equalsIgnoreCase(option2)) {
            for (int i = 1; i < stringIn.length(); i += 2) { //нечетный
                char result = stringIn.charAt(i);
                System.out.print(result);
            }
        } else {
            System.out.println("Sorry, request is wrong");
        }


}
}

