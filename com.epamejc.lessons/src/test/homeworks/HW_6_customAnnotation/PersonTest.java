package homeworks.HW_6_customAnnotation;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void MyAnnotationTest() {
        Person person = new Person();

        String expectedName = "Ilya";
        String actualName = person.getName();
        assertEquals(expectedName, actualName);

        int expectedAge = 23;
        int actualAge = person.getAge();
        assertEquals(expectedAge, actualAge);
    }
}