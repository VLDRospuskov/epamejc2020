package lessons.lesson5.example3;

public class Logic {

    static {
        System.out.println("Static logic");
    }

    {
        System.out.println("Logic");
    }

    public Logic() {
        System.out.println("Constructor Logic");
    }

    public Logic(int x) {
        System.out.println(x + " Constructor Logic");
    }

}
