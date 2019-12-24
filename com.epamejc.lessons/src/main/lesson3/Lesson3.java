package main.lesson3;

import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
//         equals and hashcode
        int[] a = {1, 2, 3};
        int[] b = a;

        a[0] = 5;

        System.out.println(Arrays.toString(b));

        int _ = 5;
    }
}
