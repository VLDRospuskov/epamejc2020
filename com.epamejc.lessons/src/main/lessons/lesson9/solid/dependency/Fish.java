package main.lessons.lesson9.solid.dependency;

public class Fish extends Animal implements AnimalSwim {

    public Fish(String name) {
        super(name);
    }

    @Override
    public String getSound() {
        return "Boo";
    }

    @Override
    public void swim() {
        System.out.println("swim");
    }

}
