package lessons.lesson8.example4;

public class Outer8 {
    
    static int count = 0;
    
    static class InnerClass {
        
        static int count = 10000;
        
        public static void display() {
            System.out.println("Outer10: " + Outer8.count);
            System.out.println("Inner: " + count);
        }
        
    }
    
}
