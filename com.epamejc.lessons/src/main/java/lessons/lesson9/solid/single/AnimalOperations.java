package lessons.lesson9.solid.single;

import java.util.ArrayList;
import java.util.List;

public class AnimalOperations {

    private final List<Animal> animalList;

    public AnimalOperations() {
        animalList = new ArrayList<>();
    }

    public void saveAnimal(Animal animal) {
        animalList.add(animal);
    }

    public Animal getAnimal(Animal animal) {
        if (animalList.contains(animal)) {
            return animal;
        } else {
            throw new UnsupportedOperationException(animal + " not found");
        }
    }

}
