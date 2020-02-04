package main.lessons.lesson9.solid.liskov;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Cat("BarsikCAT");
        Animal animal2 = new Dog("RijikDOG");
        AnimalOperations animalOperations = new AnimalOperations();
        animalOperations.saveAnimal(animal);
        animalOperations.saveAnimal(animal2);
        animalOperations.getSound(animal);
        animalOperations.getSound(animal2);
        System.out.println(animalOperations.getSound(animal));
        System.out.println(animalOperations.getAnimal(animal2));
    }

}
