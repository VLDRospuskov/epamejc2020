package homeworks.java.hw6;

import lombok.Data;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

@Data
public class Person {

    private String name;
    private int age;

    @PersonFields(name = "Valera", age = 43)
    public Person() {
        try {
            Constructor<Person> constructor = Person.class.getDeclaredConstructor();
            PersonFields annotation = constructor.getAnnotation(PersonFields.class);
            this.name = annotation.name();
            this.age = annotation.age();
        } catch (NoSuchMethodException e) {
            System.out.println("No such method! " + e);
        }
    }

}
