package homeworks.java.annotations;

import homeworks.java.annotations.utils.PersonReflectiveDefaults;
import org.junit.Assert;
import org.junit.Test;

public class PersonReflectiveDefaultsSetDefaultTest {

    @Test
    public void testSetDefault() {

        Person personNoArgsConstructor = new Person();
        Person personToTest = new Person();

        PersonReflectiveDefaults.setDefault(personToTest);

        comparePersonFields(personNoArgsConstructor, "", "");
        comparePersonFields(personToTest, "John Doe", "unknown");
    }

    private void comparePersonFields(Person person, String name, String age) {

        Assert.assertEquals(name, person.getName());
        Assert.assertEquals(age, person.getAge());

    }
}
