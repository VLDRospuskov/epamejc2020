package main.homeworks.homework6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

@AllArgsConstructor
@Data
public class Person {

    String name;
    int age;

    @SneakyThrows
    @CustomAnnotation(name = "Nik", age = 24)
    public Person() {
        Constructor constructor = Person.class.getConstructor();
        CustomAnnotation customAnnotation = constructor.getDeclaredAnnotation(CustomAnnotation.class);
        this.name = customAnnotation.name();
        this.age = customAnnotation.age();
    }
}
