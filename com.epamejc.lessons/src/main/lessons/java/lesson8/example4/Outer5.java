package lessons.java.lesson8.example4;

public class Outer5 {

    Inner inner;

    Outer5() {
        inner = new Inner();
    }
    class Inner {
        public final static int pubfsi_pole = 22;
        private final static int prfsi_polr = 33;
    }

    public void callMethodInInner() {
        System.out.println(Inner.prfsi_polr);
        System.out.println(Inner.pubfsi_pole);
    }

}
