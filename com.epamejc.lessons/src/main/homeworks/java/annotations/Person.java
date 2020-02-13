package homeworks.java.annotations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@MyAnnotation(name = "John Doe", age = "unknown")
public class Person {

    private String name;
    private String age;

    public Person() {

        name = "";
        age = "";

    }

}
