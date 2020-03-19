package homeworks.java.hw6;

import lombok.Data;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

@Data
public class Person {

    private String name;
    private int age;

    @PersonFields(name = "Valera", age = 43)
    public Person() {
            this.name = getAnnotation().name();
            this.age = getAnnotation().age();
    }

    @SneakyThrows
    private PersonFields getAnnotation() {
        Constructor<Person> constructor = Person.class.getDeclaredConstructor();
        return constructor.getAnnotation(PersonFields.class);
    }

}
