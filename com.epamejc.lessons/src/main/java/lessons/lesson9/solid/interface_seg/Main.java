package lessons.lesson9.solid.interface_seg;

public class Main {

    public static void main(String[] args) {
        Cat animal = new Cat("BarsikCAT");
        Dog animal2 = new Dog("RijikDOG");
        Animal animal3 = new Fish("murzikFISH");
        AnimalOperations animalOperations = new AnimalOperations();
//        animalOperations.saveAnimal(animal);
//        animalOperations.saveAnimal(animal2);
//        animalOperations.getSound(animal);
//        animalOperations.getSound(animal2);
//        System.out.println(animalOperations.getSound(animal));
//        System.out.println(animalOperations.getAnimal(animal2));

        animal2.swim();
        animal2.walk();

        Fish fish = (Fish) animal3;
        fish.swim();
//        fish.walk();
    }

}
