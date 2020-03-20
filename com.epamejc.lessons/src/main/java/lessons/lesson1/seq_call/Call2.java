package lessons.lesson1.seq_call;

public class Call2 extends Call {

    static {
        System.out.println("1. Call2 static block");
    }

    {
        System.out.println("2. Call2 init block");
    }

    public Call2() {
        System.out.println("3. Call2 constructor");
    }
}
