package homework.strings;
import java.util.Scanner;

public class strings3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input your string: ");
        String stringIn = in.nextLine();

        System.out.print("Input the first index, then press 'enter' to input the second one ");
        int index1 = in.nextInt();
        int index2 = in.nextInt();


        StringBuilder ScrambleString = new StringBuilder(stringIn);
        char symbol1 = ScrambleString.charAt(index1);
        char cash = ScrambleString.charAt(index2);
        ScrambleString.setCharAt(index2, symbol1);
        ScrambleString.setCharAt(index1, cash);
        System.out.println(ScrambleString.toString());

    }
}
