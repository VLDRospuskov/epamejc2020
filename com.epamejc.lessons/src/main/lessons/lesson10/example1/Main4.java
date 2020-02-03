package main.lessons.lesson10.example1;

public class Main4 {

    public static void main(String[] args) {
        doThrow();
    }

    public static void doThrow() {
        try {
            getCheckedThrowException();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void getCheckedThrowException() throws Exception {
        throw new Exception();
    }

}
