package homeworks.homework2.arrays;

import homeworks.control.exeption.IllegalDataException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RandomCharTest {
    RandomChar randomChar;
    @Before
    public void setUp() throws Exception {
        randomChar = new RandomChar();
    }

    @Test
    public void testCheckArray() {
        String request = "2 2";
        String request2 = "20 12";

        Integer[] expected = {2, 2};
        Integer[] expected2 = {20, 12};

        assertArrayEquals(expected,randomChar.chekArray(request));
        assertArrayEquals(expected2,randomChar.chekArray(request2));
    }
    @Test(expected = IllegalDataException.class)
    public void testIllegalCheckArray() {
        String request = "2 2 2";
        randomChar.chekArray(request);
    }
    @Test(expected = IllegalDataException.class)
    public void testIllegalStringCheckArray() {
        String request = "hellow";
        randomChar.chekArray(request);
    }
    @Test(expected = IllegalDataException.class)
    public void testIllegalSmallCheckArray() {
        String request = "2";
        randomChar.chekArray(request);
    }

    @Test
    public void takeMakeRandomChar() {
       List<Character> chars = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                'o','p','q','r','s','t','u','v','w','x','y','z');
        char random = randomChar.makeRandomChar();
        assertTrue(chars.contains(random));
        char random2 = randomChar.makeRandomChar();
        assertTrue(chars.contains(random2));
        char random3 = randomChar.makeRandomChar();
        assertTrue(chars.contains(random3));
        char random4 = randomChar.makeRandomChar();
        assertTrue(chars.contains(random4));
        char random5 = randomChar.makeRandomChar();
        assertTrue(chars.contains(random5));
    }

    @Test
    public void testGetResult() {
        String request = "5 5";
        String request2 = "4 5";
        String request3 = "3 2";
        String request4 = "2 3";

        int excepted = 55;
        int excepted2 = 44;
        int excepted3 = 15;
        int excepted4 = 14;

        assertEquals(excepted,randomChar.getResult(request).length());
        assertEquals(excepted2,randomChar.getResult(request2).length());
        assertEquals(excepted3,randomChar.getResult(request3).length());
        assertEquals(excepted4,randomChar.getResult(request4).length());

    }

    @Test(expected = IllegalDataException.class)
    public void testIllegalDataStringGetResult(){
        String request = "hellow";
        randomChar.getResult(request);
    }
    @Test(expected = IllegalDataException.class)
    public void testIllegalDataOneIndexGetResult(){
        String request = "1";
        randomChar.getResult(request);
    }
}