package homeworks.homework06;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

@Setter
@Getter
public class Person {
    private String name;
    private int age;

    @SneakyThrows
    @DefaultValues(name = "Alex", age = 18)
    public Person() {
        Constructor constructor = Person.class.getConstructor();
        DefaultValues defaultValues = constructor.getDeclaredAnnotation(DefaultValues.class);
        setName(defaultValues.name());
        setAge(defaultValues.age());
    }
}
