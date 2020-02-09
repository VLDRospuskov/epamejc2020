package lessons.java.solid.open;

public class AnimalOperationsWithLog extends AnimalOperations {

    @Override
    public Animal getAnimal(Animal animal) {
        System.out.println("get animal");
        return super.getAnimal(animal);
    }

}
