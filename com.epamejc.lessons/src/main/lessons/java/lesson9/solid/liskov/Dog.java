package lessons.java.lesson9.solid.liskov;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String getSound() {
        return "Wooh";
    }

}
