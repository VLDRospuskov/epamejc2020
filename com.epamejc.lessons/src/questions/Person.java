package questions;

import lombok.Data;

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
