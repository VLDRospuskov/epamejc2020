package homeworks.homework2_arrays;

import homeworks.control.exeption.IllegalDataException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PyramidTest {
    private Pyramid pyramid;
    @Before
    public void setUp(){
        pyramid = new Pyramid();
    }
    @Test
    public void getResult() {
        String request = "1";
        String request2 = "5";
        String request3 = "10";

        int expected = 2;
        int expected2 = 20;
        int expected3 = 65;

        assertEquals(expected,pyramid.getResult(request).length());
        assertEquals(expected2,pyramid.getResult(request2).length());
        assertEquals(expected3,pyramid.getResult(request3).length());
    }
    @Test(expected = IllegalDataException.class)
    public void getExResult() {
        String request = "hellow";
        pyramid.getResult(request);
    }
    @Test(expected = IllegalDataException.class)
    public void getEx2Result() {
        String request = "";
        pyramid.getResult(request);
    }
    @Test(expected = IllegalDataException.class)
    public void getEx3Result() {
        String request = "12.2";
        pyramid.getResult(request);
    }
    @Test(expected = IllegalDataException.class)
    public void getEx4Result() {
        String request = "2 2";
        pyramid.getResult(request);
    }
}