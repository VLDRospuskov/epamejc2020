package main.homeworks.hw6;

import lombok.Data;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

@Data
public class Person {

    private String name;
    private int age;

    @PersonFields(name = "Valera", age = 43)
    public Person() {
        Constructor[] constructors = Person.class.getConstructors();
        Annotation annotation = constructors[0].getAnnotation(PersonFields.class);
        PersonFields ps = (PersonFields) annotation;
        this.name = ps.name();
        this.age = ps.age();
    }

}
