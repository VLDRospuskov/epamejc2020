package lessons.lesson5.example4;

public class A {

    private int x = 1;
    private static int y = 2;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int nonStaticGetY() {
        return y;
    }

    public void nonStaticSetY(int y) {
        A.y = y;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        A.y = y;
    }
}
