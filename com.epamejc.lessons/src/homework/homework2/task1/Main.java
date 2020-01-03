package homework.homework2.task1;

//
public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        //create immutable class
        Dog dog = new Dog("Tofu", 2, "Shiba Inu");
        //Print values
        System.out.println("Dog №1");
        System.out.println(dog.toString());
        //Try to change private field
        //dog.age=20; Compile error
        Dog dog2 = new Dog("Sharik", 3, "Pug");
        System.out.println("Dog №2");
        System.out.println(dog2.toString());
    }
}
