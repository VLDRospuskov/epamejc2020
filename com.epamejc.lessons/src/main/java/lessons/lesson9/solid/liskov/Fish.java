package lessons.lesson9.solid.liskov;

public class Fish extends Animal {
    
    public Fish(String name) {
        super(name);
    }
    
    @Override
    public String getSound() {
        return "Boo";
    }
    
}
