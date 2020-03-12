package homework.homework6;

import homework.homework3.arrays.CharMatrix;
import lombok.Data;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomAnnotationProcessorTest {

    private final String NAME = "Test";
    private final int AGE = 10;

    @Data
    private class Helper{

        private String name;
        private int age;

        @CustomAnnotation(name = NAME, age = AGE)
        public Helper() {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void process() {
        Helper instance = new Helper();
        CustomAnnotationProcessor.process(instance);
        assertEquals(NAME, instance.name);
        assertEquals(AGE, instance.age);

        CustomAnnotationProcessor.process(new CharMatrix());
    }
}