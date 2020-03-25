package lessons.java.lesson21.example11;

public class Main {

    public static void main(String[] args) {
        try {
            method();
        } catch (Error e) {
            System.out.println("IS THROWING ILLEGAL");
        }
    }

    public static void method() {
        throw new RuntimeException("IS THROWING RUNTIME EXCEPTION");
    }
}
