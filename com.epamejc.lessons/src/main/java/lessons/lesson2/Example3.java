package lessons.lesson2;

public class Example3 {
    
    public static void main(String[] args) {
        
        Outer:
        for (int i = 0; i < 10; i++) {
            System.out.println("cycle1");
            for (int j = 0; j < 10; j++) {
                System.out.println("cycle2");
                break Outer;
            }
        }
    }
    
}
