package homework.arrays;
import java.util.Scanner;


public class pyramid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a pyramid height: ");
        int height = in.nextInt();
        int length = height;


        for (int j = 0; j < height; j++)
        {
            char[] charArray = new char[length];
            for (int i = 0; !(i >= length); i++)
            {
                charArray[i] = 'X';
            }
            System.out.println(charArray);
            length --;
        }
     }
}
