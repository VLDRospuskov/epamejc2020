package lessons.lesson8.example4;

import java.util.Date;

public class Outer22 {
    
    private Inner inner;
    private String str;
    private Date date;
    
    Outer22() {
        inner = new Inner();
    }
    
    public void callMethodInInner() {
        inner.method();
    }
    
    class Inner {
    
        public void method() {
            System.out.println("method");
        }
    
    }
    
}
