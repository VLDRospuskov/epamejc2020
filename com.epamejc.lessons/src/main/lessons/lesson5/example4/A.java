package main.lessons.lesson5.example4;

public class A {

    private int x;
    private static int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        A.y = y;
    }
}
