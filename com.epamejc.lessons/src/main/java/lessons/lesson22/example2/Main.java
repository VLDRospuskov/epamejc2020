package lessons.java.lesson22.example2;

public class Main {

    public static void main(String[] args) {
        int number = 10;
        try {
            System.out.println(number++); // 10
        } catch (Exception e) {
            System.out.println(number++);
        } finally {
            System.out.println(++number); // 12
        }
        System.out.println(number); // 12

    }
}
// 10
