package main.homeworks.java.homework6;

import lombok.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {

    @NonNull
    private String name;
    private int age;

    @InitializePerson(name = "error", age = 333)
    public Person(int age) {
        this.age = age;
        this.name = "John Doe";
    }

    @SneakyThrows
    @InitializePerson(name = "Jack", age = 33)
    public Person() {
        Constructor constructor = Person.class.getConstructor();
        for (Annotation a : constructor.getDeclaredAnnotations()) {
            if (a instanceof InitializePerson) {
                this.name = ((InitializePerson) a).name();
                this.age = ((InitializePerson) a).age();
            }
        }
    }

}
