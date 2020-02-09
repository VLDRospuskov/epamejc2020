package lessons.java.solid.liskov;

public class AnimalOperationsWithLog extends AnimalOperations {

    @Override
    public Animal getAnimal(Animal animal) {
        System.out.println("get animal");
        return super.getAnimal(animal);
    }

}
