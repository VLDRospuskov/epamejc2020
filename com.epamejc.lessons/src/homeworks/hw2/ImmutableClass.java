package homeworks.hw2;

public final class ImmutableClass {

    private final int a;

    public ImmutableClass(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        ImmutableClass object = new ImmutableClass(512);
        System.out.println("oh, you are finally awake");
    }
}
