package main.java.homework.arrays.pyramid;
import java.util.Scanner;


public class Pyramid {
    int height;
    int length;

    public void run () {
        input();
        buildThePyramid();
    }

    private void input(){

            Scanner in = new Scanner(System.in);
            System.out.print("Input a pyramid height: ");
             height = in.nextInt();
             length = height;
        }

        private void buildThePyramid(){
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

