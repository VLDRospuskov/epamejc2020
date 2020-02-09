package lessons.java.lesson10.example2;

public class Main {

    public static void main(String[] args) {
        try {
            method();
        } catch (MyCustomException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void method() {
        throw new MyCustomException("My custom exception");
    }

}
