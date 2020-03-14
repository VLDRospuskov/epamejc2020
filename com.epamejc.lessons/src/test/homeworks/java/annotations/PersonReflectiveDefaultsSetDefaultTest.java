package homeworks.java.annotations;

import org.junit.Assert;
import org.junit.Test;

public class PersonReflectiveDefaultsSetDefaultTest {

    @Test
    public void testSetDefault() {

        Person person = new Person();

        Assert.assertEquals("John Doe", person.getName());
        Assert.assertEquals("unknown", person.getAge());

    }

}
