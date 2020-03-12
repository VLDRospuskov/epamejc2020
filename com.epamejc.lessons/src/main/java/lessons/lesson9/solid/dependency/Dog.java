package lessons.lesson9.solid.dependency;

public class Dog extends Animal implements AnimalSwim, AnimalWalk {
    
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public String getSound() {
        return "Wooh";
    }
    
    @Override
    public void swim() {
        System.out.println("Swim dog");
    }
    
    @Override
    public void walk() {
        System.out.println("Walk dog");
    }
    
}
