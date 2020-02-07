package homeworks.homework2.recursion;

import homeworks.control.exeption.IllegalDataException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumbersTest {
    private FibonacciNumbers fib;
    @Before
    public void setUp() throws Exception {
        fib = new FibonacciNumbers();
    }
    @Test
    public void testCorrectIn(){
        String[] nums = {"1","2","3","8","0"};
        String[] expected = {"1","1","2","21","0"};
        String[] actual = new String[nums.length];
        int i = 0;
        for (String num : nums){
            actual[i] = fib.getResult(num);
            i++;
        }
        assertArrayEquals(expected,actual);
    }
    @Test(expected = IllegalDataException.class)
    public void testExceptionCall(){
        String[] nums = {"-1","qwe","3.2","","2wwq"};
        for (String num : nums){
            fib.getResult(num);
        }
    }
    @Test
    public void testExceptionMessage(){
        String numString = "whe";
        String numNegative = "-2";
        String numDouble = "2.2";
        String isNotInt = " is not Integer.";
        String isNegative = " input can't be negative";

        try{
            fib.getResult(numString);
            fail();
        } catch (IllegalDataException e){
            assertEquals(numString+isNotInt,e.getMessage());
        }
        try{
            fib.getResult(numNegative);
            fail();
        } catch (IllegalDataException e){
            assertEquals(numNegative+isNegative,e.getMessage());
        }
        try{
            fib.getResult(numDouble);
            fail();
        } catch (IllegalDataException e){
            assertEquals(numDouble+isNotInt,e.getMessage());
        }
    }
}