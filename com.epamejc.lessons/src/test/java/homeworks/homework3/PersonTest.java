package homeworks.homework3;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    private static Person person;

    @BeforeClass
    public static void beforeClass() {
        person = new Person();
    }

    @Test
    public void getStr() {
        String expected = "Barsik";
        String actual = person.getStr();
        assertEquals(expected, actual);
    }

    @Test
    public void getAge() {
        int expected = 6;
        int actual = person.getAge();
        assertEquals(expected, actual);
    }

}