package lessons.java.lesson22.example11;

public class Main {


    public static void main(String[] args) {
        Animal animal = new Cat();
        Animal animal2 = new Dog();
//        System.out.println(animal.getAge());
//        System.out.println(animal.getName());
//        System.out.println(animal2.getWeight());
    }

}


class Animal {

     public int getAge() {
           return 1;
     }

     public int getAge(int age) {
           return 3;
     }

}

class Cat extends Animal {

    public int getAge() {
        return 2;
    }

    public String getName() {
        return "Barsik";
    }

}

class Dog extends Animal {

    public int getAge() {
        return 10;
    }

    public int getWeight() {
        return 5000;
    }

}