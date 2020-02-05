package lessons.java.lesson8.example1;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("barsik");
        cat.print();
        cat.anTest();
        Field[] fields = Cat.class.getDeclaredFields();
        System.out.println(fields[0].isAnnotationPresent(TestAnnotation.class));
    }

}
