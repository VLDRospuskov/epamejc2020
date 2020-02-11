package questions;

import lombok.Data;

@Data

public class Person {

    private String name;
    private String age;

    public Person() {
        name = "";
        age = "";
    }
}
