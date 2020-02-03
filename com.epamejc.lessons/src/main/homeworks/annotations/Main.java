package main.homeworks.annotations;

import com.sun.istack.internal.NotNull;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        System.out.println(person);


        String name = person.getClass().getAnnotation(MyAnnotation.class).name();
        int age = person.getClass().getAnnotation(MyAnnotation.class).age();

        if (name != null && age != 0) {
            person.setName(name);
            person.setAge(age);
        }

        System.out.println(person);
    }
}
