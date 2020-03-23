package lessons.java.lesson21.example6;

public class Main {

    public static void main(String[] args) {
        String name = "Barsik";
        int age = 10;
        final Cat cat = new Cat();
        cat.result(name, age);
//        int animal = (name, age) -> {
//
//        }

//        int result = cat.result((name, age) -> name == null ? age : age + 1);
//        new Animal() {
//            @Override
//            public int result(String name, int age) {
//                return 0;
//            }
//        };

        Animal animal = (n, a) -> n == null ? a : a + 1;
        animal.result(name, age);
    }
}

@FunctionalInterface
interface Animal {

    int result(String name, int age);

}

class Cat implements Animal {

    @Override
    public int result(String name, int age) {
        if (name == null) {
            return age;
        } else {
            return age + 1;
        }
    }

}