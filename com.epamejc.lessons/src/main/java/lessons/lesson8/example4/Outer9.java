package lessons.lesson8.example4;

public class Outer9 {
    
    private int x = 3;
    
    public Outer9(int x) {
        this.x = x;
    }
    
    static class Inner1 {
        
        public Inner1() {
            System.out.println("Inner1");
        }
        
        public void method() {
            Outer9 out = new Outer9(10);
            System.out.println("out.x=" + out.x);
        }
        
    }
    
}

class Main4 {
    
    public static void main(String[] args) {
        Outer9.Inner1 inner1 = new Outer9.Inner1();
        inner1.method();
    }
    
}
