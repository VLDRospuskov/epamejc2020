package lessons.lesson6.example6;

public class Quadrate implements Square {

    private int a;

    public Quadrate(int a) {
        this.a = a;
    }

    public double square() {
        return a * a;
    }

    public void print() {
        System.out.println("Quadrate");
    }

}
