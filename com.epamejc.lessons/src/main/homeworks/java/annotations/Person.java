package homeworks.java.annotations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Person {

    private String name;
    private String age;

    @MyAnnotation(name = "John Doe", age = "unknown")
    public Person() {

        setDefaults();

    }

    @SneakyThrows
    private void setDefaults() {

        MyAnnotation annotation = Person.class.getConstructor().getDeclaredAnnotation(MyAnnotation.class);
        name = annotation.name();
        age = annotation.age();

    }

}