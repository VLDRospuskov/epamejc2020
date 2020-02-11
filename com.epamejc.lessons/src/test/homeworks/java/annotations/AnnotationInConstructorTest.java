package homeworks.java.annotations;

import org.junit.Assert;
import org.junit.Test;

public class AnnotationInConstructorTest {

    @Test
    public void emptyConstructorTest() {
        Person person = new Person();
        String expectedName = "John Doe",
                expectedAge = "unknown";

        Assert.assertEquals(expectedName, person.getName());
        Assert.assertEquals(expectedAge, person.getAge());
    }

    @Test
    public void allArgsConstructor() {
        Person person = new Person("John Smith", "24");
        String expectedName = "John Smith",
                expectedAge = "24";

        Assert.assertEquals(expectedName, person.getName());
        Assert.assertEquals(expectedAge, person.getAge());
    }
}
