package lessons.lesson8.example4;

public class Outer5 {
    
    Inner inner;
    
    Outer5() {
        inner = new Inner();
    }
    
    public void callMethodInInner() {
        System.out.println(Inner.prfsi_polr);
        System.out.println(Inner.pubfsi_pole);
    }
    
    class Inner {
        
        public final static int pubfsi_pole = 22;
        private final static int prfsi_polr = 33;
        
    }
    
}
