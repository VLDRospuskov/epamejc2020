package homeworks.java.hw6;

import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest {

    Person person;

    @Before
    public void setUp() {
        person = new Person();
    }

    @Test
    public void myAnnotationTest() {
        String expectedName = "Valera";
        String actualName = person.getName();
        assertEquals(expectedName, actualName);

        int expectedAge = 43;
        int actualAge = person.getAge();
        assertEquals(expectedAge, actualAge);
    }

}
