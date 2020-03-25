package experiments.oca.chapter4;

public class Jsp {
    public static String s = "";

    static {
        System.out.println("static");
    }

    {
        System.out.println("init");
    }

    {
        System.out.println("init2");
    }
}
