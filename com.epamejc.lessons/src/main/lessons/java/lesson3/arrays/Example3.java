package lessons.java.lesson3.arrays;

public class Example3 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        int[][] arrD = {arr, null};
        int[][] arrD2 = arrD.clone(); // {arr, null};

        System.out.println(arrD == arrD2);

        System.out.println(arrD[0] == arrD2[0]);
    }
}
