package lessons.lesson9.solid.dependency;

public class Cat extends Animal implements AnimalSwim, AnimalWalk {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String getSound() {
        return "Meow";
    }

    @Override
    public void swim() {
        System.out.println("Swim cat");
    }

    @Override
    public void walk() {
        System.out.println("Walk cat");
    }
}
