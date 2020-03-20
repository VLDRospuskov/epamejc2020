package lessons.lesson1.seq_call;

public class Call {

    static {
        System.out.println("1. Call static block");
    }

    {
        System.out.println("2. Call init block ");
    }

    public Call() {
        System.out.println("3. Call constructor ");
    }

}
