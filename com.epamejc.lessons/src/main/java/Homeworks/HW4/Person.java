package Homeworks.HW4;

public class Person {

    private String name;
    private int age;


    @MyAnnotation(name="Alice", age=30)
    public Person() {
        // empty constructor

        // reflection
        MyAnnotation myAnnotation = getAnnotation();
        this.name = myAnnotation.name();
        this.age = myAnnotation.age();
    }

    private MyAnnotation getAnnotation() {
        return getClass().getDeclaredConstructors()[0].getAnnotation(MyAnnotation.class);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age;
    }
}
