package main.lessons.lesson9.solid.dependency;

public class AnimalOperationsWithLog extends AnimalOperations {

    @Override
    public Animal getAnimal(Animal animal) {
        System.out.println("get animal LOG");
        return super.getAnimal(animal);
    }

}
