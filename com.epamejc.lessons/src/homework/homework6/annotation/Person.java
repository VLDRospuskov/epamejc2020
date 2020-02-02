package homework.homework6.annotation;

import lombok.Data;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

@Data
public class Person {
    private String name;
    private int age;

    @SneakyThrows
    @PersonInfo(name = "Rick", age = 90)
    Person() {
        Constructor<? extends Person> constructor = this.getClass().getDeclaredConstructor();
        PersonInfo annotation = constructor.getAnnotation(PersonInfo.class);
        this.name = annotation.name();
        this.age = annotation.age();
    }
}
