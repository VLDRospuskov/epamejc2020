/*example of immutable class*/

package main.homework.hw2;

public final class MyImmutableClass {
    private final String value;

    public MyImmutableClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}