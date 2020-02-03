package main.homeworks.annotations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@MyAnnotation(name = "John Doe", age = "unknown")
public class Person {

    private String name;
    private String age;

    public Person() {
        name = "";
        age = "";
    }
}
