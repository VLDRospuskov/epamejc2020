package homeworks.homework6;

import lombok.Data;

import java.lang.reflect.Constructor;

@Data
public class Person {

    private String name;
    private int age;

    @PersonInit(name = "Bruce Wayne", age = 30)
    public Person() {
        this.name = getPersonInit().name();
        this.age = getPersonInit().age();
    }

    private PersonInit getPersonInit() {
        Constructor<?>[] declaredConstructors = Person.class.getDeclaredConstructors();
        return declaredConstructors[0].getAnnotation(PersonInit.class);
    }

}
