package test.homeworks.homework6;

import main.homeworks.homework6.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomAnnotationTest {
    private static Person person;

    @Before
    public void initialization() {
        person = new Person();
    }

    @Test
    public void testConstructorName() {
        String actual = person.getName();
        String expected = "Nik";
        assertEquals(expected, actual);
    }

    @Test
    public void testConstructorAge() {
        int actual = person.getAge();
        int expected = 24;
        assertEquals(expected, actual);
    }
}
