package lessons.lesson1.seq_call;

public class Call {
    
    static {
        System.out.println("1. Another class static");
    }
    
    {
        System.out.println("2. Another class dynamic");
    }
    
    public Call() {
        System.out.println("3. Another class constructor ");
    }
    
}
