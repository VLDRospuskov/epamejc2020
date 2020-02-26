package lessons.java.lesson5.example3;

public class Logic {

    static {
        System.out.println("Static logic");
    }

    {
        System.out.println("StringsCreator");
    }

    public Logic() {
        System.out.println("Constructor StringsCreator");
    }

    public Logic(int x) {
        System.out.println(x + " Constructor StringsCreator");
    }

}
