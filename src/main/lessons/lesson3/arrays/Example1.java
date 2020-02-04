package main.lessons.lesson3.arrays;

public class Example1 {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Integer[] arrInt = new Integer[10];
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(arr[5]);
        System.out.println(arrInt[5]);
//        System.out.println(arr2[5]);

        int[][] arrD = new int[3][];
        System.out.println("error: " + arrD[3][0]);

        int[][] arrD2 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] arrD3 = {
                {1, 2},
                {3, 4, 5},
                {6, 7, 8, 9}
        };



    }

}
