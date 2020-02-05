package lessons.lesson5.example3;

public class LogicBlock extends Logic {

    private static int x = 10;

    static {
        System.out.println("Static logicBlock");
    }
    {
        System.out.println("LogicBlock");
    }

    public LogicBlock() {
        super(x);
        System.out.println("Constructor logicBlock");
    }
}
