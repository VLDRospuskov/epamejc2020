package experiments.example2.example4;

public class Outer3 {

    class Inner {
        private int i;
        public final static int static_pole = 10; // ERROR
        public int pubfsi_pole = 20;
        private final static int prfsi_polr = 33;
    }

}

class Main2 {

    public static void main(String[] args) {
        int pubfsi_pole = Outer3.Inner.static_pole;
    }

}
