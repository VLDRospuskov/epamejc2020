package homeworks.homework9_multithreading.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Person {
    private final String name;
    private final Long card;

    @Override
    public String toString() {
        return name;
    }
}
