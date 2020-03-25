package lessons.java.lesson21.example5;

public class Main {

    public static void main(String[] args) {
        int age = 10;
        final class Cat extends Animal {
            public int getAge() {
                return age;
            }
        }
        System.out.println(new Cat().getAge());
    }
}

class Animal {

}