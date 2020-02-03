package main.homeworks.annotations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@MyAnnotation(name = "Stefan", age = 89)
public class Person {

    private String name;
    private int age;

    public Person () {
       name = "";
       age = 0;
    }
}
