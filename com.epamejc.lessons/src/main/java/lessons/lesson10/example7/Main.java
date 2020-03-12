package lessons.lesson10.example7;

public class Main {
    
    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("HERE");
        } finally {
            throw new NullPointerException();
        }
    }
    
    private static void method() {
        throw new RuntimeException();
    }
    
    public static void methodThrow() throws MyException {
        throw new MyException("THROW RUNTIME EXCEPTION", new ArithmeticException("ARTHIMETICS "), false, false);
    }
    
}
