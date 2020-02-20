package Homeworks.HW4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class Person {

    private String name;
    private int age;


    @MyAnnotation(name="Alice", age=30)
    public Person() {
        // empty constructor

        // reflection
        MyAnnotation myAnnotation = getClass().getDeclaredConstructors()[0].getAnnotation(MyAnnotation.class);
        this.name = myAnnotation.name();
        this.age = myAnnotation.age();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age;
    }
}
