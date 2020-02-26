package homeworks.HM6_Annotation;

import org.junit.Assert;
import org.junit.Test;

public class AnnotationTest {



    @Test
    public void testConstructor() {
        Person person = new Person();

        String expected = "Alex 18";
        String actual = person.getName() + " " + person.getAge();

        Assert.assertEquals(expected, actual);
    }
}
