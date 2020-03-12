package lessons.lesson8.example4;

public class Outer3 {
    
    class Inner {
        
        public final static int static_pole = 10; // ERROR
        private final static int prfsi_polr = 33;
        public int pubfsi_pole = 20;
        private int i;
        
    }
    
}

class Main2 {
    
    public static void main(String[] args) {
        int pubfsi_pole = Outer3.Inner.static_pole;
    }
    
}
