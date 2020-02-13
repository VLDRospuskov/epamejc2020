package homeworks.HW6_annotations;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    /**
     * Test with default constructor and annotation data
     */
    @Test
    public void testAnnotationsForConstructor() {
        Student student = new Student();
        String expectedName = "Alex";
        String actualName = student.getName();
        int expectedAge = 25;
        int actualAge = student.getAge();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAge, actualAge);
    }

    /**
     * Test with custom constructor without annotation
     */
    @Test
    public void testCustomConstructor() {
        Student student = new Student(26, "Andrew");
        String expectedName = "Andrew";
        String actualName = student.getName();
        int expectedAge = 26;
        int actualAge = student.getAge();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAge, actualAge);
    }
}