package homeworks.homework6;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTest {

    private static Person person;

    @BeforeClass
    public static void setup() {
        person = new Person();
    }

    @Test
    public void testPerson() {
        String personNameExpected = "Bruce Wayne";
        int personAgeExpected = 30;

        Assert.assertEquals(personNameExpected, person.getName());
        Assert.assertEquals(personAgeExpected, person.getAge());
    }

}