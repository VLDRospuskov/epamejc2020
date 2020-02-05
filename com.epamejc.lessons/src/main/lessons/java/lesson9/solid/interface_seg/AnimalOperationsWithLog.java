package lessons.java.lesson9.solid.interface_seg;

public class AnimalOperationsWithLog extends AnimalOperations {

    @Override
    public Animal getAnimal(Animal animal) {
        System.out.println("get animal");
        return super.getAnimal(animal);
    }

}
