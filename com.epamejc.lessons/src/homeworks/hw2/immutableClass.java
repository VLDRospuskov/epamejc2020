package homeworks.hw2;

public final class immutableClass {

    private final int a;

    public immutableClass(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        immutableClass object = new immutableClass(512);
        System.out.println("oh, you are finally awake");
    }
}
