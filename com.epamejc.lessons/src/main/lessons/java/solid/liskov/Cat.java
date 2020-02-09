package lessons.java.solid.liskov;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String getSound() {
        return "Meow";
    }
}
