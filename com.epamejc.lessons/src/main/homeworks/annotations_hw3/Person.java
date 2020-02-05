package main.homeworks.annotations_hw3;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Constructor;

@Getter
@Setter
public class Person {

    private String name;
    private int age;

    @CustomAnnotation(name = "Barsik", age = 6)
    public Person() {
        Constructor<Person> personConstructor = null;
        try {
            personConstructor = Person.class.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        assert personConstructor != null;
        CustomAnnotation customAnnotation = personConstructor.getAnnotation(CustomAnnotation.class);
        this.name = customAnnotation.name();
        this.age = customAnnotation.age();
    }

    @Override
    public String toString() {
        return "Person[" + "name: " + name + ", age = " + age + "]";
    }
}
