package lessons.lesson2;

public class Example2 {

    public static void main(String[] args) {
        int x = 863;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(~x));

        int y = 435;
        System.out.println(Integer.toBinaryString(x&y));
        System.out.println(Integer.toBinaryString(x|y));

        // 11111...111 < 16
        // 00000...111 < 6
        // 00000000000....11(11111111111) < 32

    }
}
