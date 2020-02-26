package lessons.java.lesson8.example4;

public class Outer13 {

    static int x = 10;

    static class Inner1 {
        public static void method() {
            System.out.println("inner1 outer.x=" + x);
        }
    }

}

class Outer14 extends Outer13.Inner1 {

    public void outer2Method() {
//         System.out.println("x="+ x); // ERROR
    }

}

