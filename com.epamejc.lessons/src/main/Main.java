public class Main {
    public static void main(String[] args) {

        String name = "Barsik";
        int age = 19;

        Animal animal = (n, m) -> n == "b"? 1 : 0;
        int result = animal.result(name, age);

    }

    @FunctionalInterface
    public interface Animal {

        int result(String name, int age);

    }
    class Cat implements Animal {

        @Override
        public int result(String name, int age) {
            return 1;
        }
    }
}

