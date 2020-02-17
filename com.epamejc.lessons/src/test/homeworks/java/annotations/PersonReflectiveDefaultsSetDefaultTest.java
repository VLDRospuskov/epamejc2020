package homeworks.java.annotations;

import org.junit.Assert;
import org.junit.Test;

public class PersonReflectiveDefaultsSetDefaultTest {

    @Test
    public void testSetDefault() {

        Person person = new Person();

        comparePersonFields(person, "John Doe", "unknown");

    }

    private void comparePersonFields(Person person, String name, String age) {

        Assert.assertEquals(name, person.getName());
        Assert.assertEquals(age, person.getAge());

    }
}
