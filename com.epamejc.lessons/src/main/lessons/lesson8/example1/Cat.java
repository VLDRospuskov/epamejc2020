package main.lessons.lesson8.example1;

import java.lang.reflect.Method;
import java.util.Date;

public class Cat extends Animal {

    @TestAnnotation
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello");
    }

    @MyAnnotation(value = "myAnnotationValue", number = 10)
    public void print() {
        Method[] declaredMethods = Cat.class.getDeclaredMethods();
        MyAnnotation annotation = declaredMethods[0].getAnnotation(MyAnnotation.class);
        System.out.println(annotation.number());
        for (int i = 0; i < annotation.number(); i++) {
            System.out.println("Cat");
        }
    }

    @SuppressWarnings("deprecation")
    public void anTest() {
        Date date = new Date();
        date.getTimezoneOffset();
    }

}
