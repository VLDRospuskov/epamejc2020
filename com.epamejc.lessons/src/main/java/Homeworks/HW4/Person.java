package Homeworks.HW4;

public class Person {

    private String name;
    private int age;


    public Person() {
        // empty constructor
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age;
    }
}
