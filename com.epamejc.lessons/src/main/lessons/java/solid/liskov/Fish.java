package lessons.java.solid.liskov;

public class Fish extends Animal {

    public Fish(String name) {
        super(name);
    }

    @Override
    public String getSound() {
        return "Boo";
    }

}
