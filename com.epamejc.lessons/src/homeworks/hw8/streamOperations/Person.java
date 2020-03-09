package homeworks.hw8.streamOperations;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;

}