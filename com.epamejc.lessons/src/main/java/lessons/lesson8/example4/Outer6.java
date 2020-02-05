package lessons.lesson8.example4;

public class Outer6 {

    public void method() {
        final int x = 3;
        class Inner1 {
            void print() {
                System.out.println("x=" + x);
            }
        }
        Inner1 obj = new Inner1();
        obj.print();
    }

}

class Main3 {

    public static void main(String[] args) {
        Outer6 outer6 = new Outer6();
        outer6.method();
    }

}
