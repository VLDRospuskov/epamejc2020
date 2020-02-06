package homeworks.homework6;

import lombok.Data;

import java.lang.reflect.Constructor;

@Data
public class Person {

    private String name;
    private int age;

    @PersonInit(name = "Bruce Wayne", age = 30)
    public Person() {
        Constructor<?>[] declaredConstructors = Person.class.getDeclaredConstructors();
        PersonInit annotation = declaredConstructors[0].getAnnotation(PersonInit.class);
        this.name = annotation.name();
        this.age = annotation.age();
    }

}
