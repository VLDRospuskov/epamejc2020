package lessons.lesson10.example5;

public class Main {

    public static void main(String[] args) {
        try {
            try {
                int sum = 42 / 0;
            } catch (ArithmeticException e1) {
                System.out.println("ARITHEMTIOC EXCEPTION");
            } finally {
                System.out.println("FINNALY 1");
            }
            throw new Exception();
        } catch (Exception e) {
            System.out.println("EXCEPTION");
        } finally {
            System.out.println("FINALLY 2");
        }
    }
}
