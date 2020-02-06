package homeworks.homework6;

import lombok.Data;

@Data
public class Person {

    private String name;
    private int age;

    @PersonInit(name = "Bruce Wayne", age = 30)
    public Person() {



    }

}
