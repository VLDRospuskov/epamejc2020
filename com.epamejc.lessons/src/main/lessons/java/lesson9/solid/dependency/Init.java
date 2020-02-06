package lessons.java.lesson9.solid.dependency;


public class Init {

    AnimalOperationsInterf animalOperationsInterf;
    AnimalOperationsInterf animalOperationsInterf2;

    public Init(AnimalOperationsInterf animalOperationsInterf, AnimalOperationsInterf animalOperationsInterf2) {
        this.animalOperationsInterf = animalOperationsInterf;
        this.animalOperationsInterf2 = animalOperationsInterf2;
    }

    public void start() {
        Cat animal = new Cat("BarsikCAT");
        Dog animal2 = new Dog("RijikDOG");
        Animal animal3 = new Fish("murzikFISH");
//        AnimalOperations animalOperations = new AnimalOperations();
        animalOperationsInterf.saveAnimal(animal);
        animalOperationsInterf.saveAnimal(animal2);
        animalOperationsInterf.getSound(animal);
        animalOperationsInterf.getSound(animal2);
        System.out.println(animalOperationsInterf.getSound(animal));
        System.out.println(animalOperationsInterf.getAnimal(animal2));

        animal2.swim();
        animal2.walk();

        Fish fish = (Fish) animal3;
        fish.swim();
//        fish.walk();
    }
}
