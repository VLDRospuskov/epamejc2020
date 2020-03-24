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

    @CustomAnnotation(name = "Nik", age = 24)
    public Person() {
        CustomAnnotation customAnnotation = getCustomAnnotation();
        this.name = customAnnotation.name();
        this.age = customAnnotation.age();
    }

    @SneakyThrows
    private CustomAnnotation getCustomAnnotation() {
        Constructor constructor = Person.class.getConstructor();
        CustomAnnotation customAnnotation = constructor.getDeclaredAnnotation(CustomAnnotation.class);
        return customAnnotation;
    }

}
