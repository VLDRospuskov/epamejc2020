package lessons.lesson10.example1;

public class Main2 {
    
    public static void main(String[] args) {
    
    }
    
}

class A {
    
    public A() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

class B extends A {
    
    public B() {
    }
    
}
