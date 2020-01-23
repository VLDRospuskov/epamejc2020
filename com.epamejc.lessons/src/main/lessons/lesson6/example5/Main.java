package main.lessons.lesson6.example5;

public class Main {

    public static void main(String[] args) {
        A aClass = new A();
        aClass.print();
        aClass.doSomething();
    }

}

class A implements Course, BaseCourse {

    @Override
    public void print() {
        System.out.println("Hello from class A");
    }

    @Override
    public void doSomething() {
        System.out.println("Because of interface Course conditions");
    }
}
