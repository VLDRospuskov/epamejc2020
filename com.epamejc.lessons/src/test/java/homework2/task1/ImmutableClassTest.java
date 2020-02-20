package homework2.task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableClassTest {

    private ImmutableClass instance;

    @Before
    public void init() {
        instance = new ImmutableClass("Hello", 123);
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void getStrFieldSuccessTest() {
        String expectedStr = "Hello";
        assertEquals(expectedStr, instance.getStrField());
    }

    @Test
    public void getIntFieldSuccessTest() {
        int expectedInt = 123;
        assertEquals(expectedInt, instance.getIntField());
    }

    @Test
    public void getStrFieldNegativeTest() {
        String expectedStr = "olleH";
        assertNotEquals(expectedStr, instance.getStrField());
    }

    @Test
    public void getIntFieldNegativeTest() {
        int expectedInt = 321;
        assertNotEquals(expectedInt, instance.getIntField());
    }
}